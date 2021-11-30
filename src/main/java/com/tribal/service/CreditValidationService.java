package com.tribal.service;

import com.tribal.dto.CreditRequest;
import com.tribal.dto.CreditResponse;

public interface CreditValidationService {
    CreditResponse creditLineValidation(CreditRequest creditRequest);
}
