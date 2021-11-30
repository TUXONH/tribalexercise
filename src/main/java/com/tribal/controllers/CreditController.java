package com.tribal.controllers;

import com.tribal.dto.CreditRequest;
import com.tribal.dto.CreditResponse;
import com.tribal.service.CreditValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class CreditController {
    private final CreditValidationService creditValidationService;

    public CreditController(CreditValidationService creditValidationService) {
        this.creditValidationService = creditValidationService;
    }

    @PostMapping("validCredit")
    public ResponseEntity<?> validCredit(@RequestBody CreditRequest request) {
        CreditResponse response = creditValidationService.creditLineValidation(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}
