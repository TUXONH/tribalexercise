package com.tribal.service;

import com.tribal.dto.CreditRequest;
import com.tribal.dto.CreditResponse;
import com.tribal.exceptions.CreditLineFailException;
import com.tribal.exceptions.RequestLimitException;
import com.tribal.repository.model.CreditLine;
import com.tribal.repository.repositories.CreditLineRepository;
import com.tribal.utils.TribalScripts;
import com.tribal.utils.CreditLineStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CreditValidation implements CreditValidationService {

    private final CreditLineRepository creditLineRepository;

    public CreditValidation(CreditLineRepository creditLineRepository) {
        this.creditLineRepository = creditLineRepository;
    }

    @Override
    public CreditResponse creditLineValidation(CreditRequest creditRequest) {
        checkTimeFromRequest();
        return checkCreditLineForValidation(creditRequest);
    }

    /*
        Check if the request is thirty seconds ahead of the last request
        and that there is no more than three request in the last two minutes
     */
    private void checkTimeFromRequest() {
        Calendar todayCalendar = TribalScripts.getCalendarFromToday();
        Date todayTime = todayCalendar.getTime();
        Optional<CreditLine> creditLine = creditLineRepository.findCreditLineByRequestedDateBetween(TribalScripts.getThirtySecondsFromCurrentDate(todayCalendar), todayTime);
        if (creditLine.isPresent()) {
            throw new RequestLimitException();
        }
        List<CreditLine> creditLines = creditLineRepository.findAllByRequestedDateBetween(TribalScripts.getTwoMinutesFromCurrentDate(todayCalendar), todayTime);
        if (creditLines.size() >= 3) {
            throw new RequestLimitException();
        }
    }

    /* This function validate the request inputs with the business rules to determinate
        If the credit line is accepted or rejected
     */
    private CreditResponse checkCreditLineForValidation(CreditRequest creditRequest) {
        BigDecimal monthlyValue;
        BigDecimal cashValue;
        boolean isValidCreditLine = false;
        CreditResponse.ResponseBuilder response = new CreditResponse.ResponseBuilder().newInstance().setCreditLine(creditRequest.getRequestedCreditLine());
        switch (creditRequest.getFoundingType()) {
            case STARTUP:
                monthlyValue = creditRequest.getMonthlyRevenue().multiply(BigDecimal.valueOf(5));
                cashValue = creditRequest.getCashBalance().multiply(BigDecimal.valueOf(3));
                isValidCreditLine = (((monthlyValue.compareTo(creditRequest.getRequestedCreditLine())) > 0) && ((cashValue.compareTo(creditRequest.getRequestedCreditLine())) > 0));
                response.setResponse(isValidCreditLine ? CreditLineStatus.EnumCreditLineStatus.APPROVED.toString() : CreditLineStatus.EnumCreditLineStatus.REJECTED.toString())
                        .setCode(isValidCreditLine ? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE);
                break;
            case SME:
                monthlyValue = creditRequest.getMonthlyRevenue().multiply(BigDecimal.valueOf(5));
                isValidCreditLine = ((monthlyValue.compareTo(creditRequest.getRequestedCreditLine())) > 0);
                response.setResponse(isValidCreditLine ? CreditLineStatus.EnumCreditLineStatus.APPROVED.toString() : CreditLineStatus.EnumCreditLineStatus.REJECTED.toString())
                        .setCode(isValidCreditLine ? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE);
                break;
            default:
                response.setResponse("FoundingType not found")
                        .setCode(HttpStatus.BAD_REQUEST);
                break;
        }
        checkCreditStatus(isValidCreditLine, creditRequest);
        return response.build();
    }

    private void checkCreditStatus(boolean isValidCreditLine, CreditRequest creditRequest) {
        Optional<CreditLine> creditLine = creditLineRepository.findByRequestedCreditLineAndValidIsTrue(creditRequest.getRequestedCreditLine());
        if (creditLine.isEmpty()) {
            List<CreditLine> creditLineList = creditLineRepository.findAllByRequestedCreditLineAndValid(creditRequest.getRequestedCreditLine(), false);
            if (creditLineList.size() >= 3) {
                throw new CreditLineFailException();
            }else {
                CreditLine newCreditLine = new CreditLine(creditRequest);
                creditLineRepository.save(newCreditLine);
            }
        }
    }

}
