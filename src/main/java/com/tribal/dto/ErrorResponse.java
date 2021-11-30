package com.tribal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private HttpStatus status;
    private int statusCode;
    private String message;
    private String exception;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    //Builder
    public static final class ErrorResponseBuilder {
        private HttpStatus status;
        private int statusCode;
        private String message;
        private String exception;
        private HashMap<String, Object> data;

        public ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseBuilder withException(String exception) {
            this.exception = exception;
            return this;
        }

        public ErrorResponseBuilder withData(HashMap<String, Object> data) {
            this.data = data;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.status = this.status;
            errorResponse.statusCode = this.statusCode == 0 ? this.status.value() : this.statusCode;
            errorResponse.message = this.message;
            errorResponse.exception = this.exception;
            return errorResponse;
        }
    }
}
