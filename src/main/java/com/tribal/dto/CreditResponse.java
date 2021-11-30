package com.tribal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditResponse {
    private final HttpStatus code;
    private final String response;
    private final BigDecimal creditLine;

    public String getResponse() {
        return response;
    }

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public HttpStatus getCode() {
        return code;
    }


    CreditResponse(ResponseBuilder ResponseBuilder) {
        this.code = ResponseBuilder.code;
        this.response = ResponseBuilder.response;
        this.creditLine = ResponseBuilder.creditLine;
    }

    public static final class ResponseBuilder {
        private HttpStatus code;
        private String response;
        private BigDecimal creditLine;

        public ResponseBuilder newInstance() {
            return new ResponseBuilder();
        }

        public ResponseBuilder() { }

        public ResponseBuilder setCode(HttpStatus code) {
            this.code = code;
            return this;
        }

        public ResponseBuilder setResponse(String response) {
            this.response = response;
            return this;
        }

        public ResponseBuilder setCreditLine(BigDecimal creditLine) {
            this.creditLine = creditLine;
            return this;
        }

        public CreditResponse build() {
            return new CreditResponse(this);
        }

    }
}
