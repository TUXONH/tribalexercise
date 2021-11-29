package com.tribal.controllers;

import com.tribal.dto.CreditRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class CreditController {
    @PostMapping("validCredit")
    public ResponseEntity<?> validCredit(@RequestBody CreditRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }
}
