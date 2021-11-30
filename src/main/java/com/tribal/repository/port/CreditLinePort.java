package com.tribal.repository.port;


import com.tribal.repository.model.CreditLine;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CreditLinePort extends CrudRepository<CreditLine, Long> {
    Optional<CreditLine> findCreditLineByRequestedDateBetween(Date lastDate, Date firstDate);

    List<CreditLine> findAllByRequestedDateBetween(Date lastDate, Date firstDate);

    Optional<CreditLine> findByRequestedCreditLineAndValidIsTrue(BigDecimal creditLine);

    List<CreditLine> findAllByRequestedCreditLineAndValid(BigDecimal creditLine, boolean valid);

}
