package com.tribal.exceptions;

public class CreditLineFailException extends RuntimeException {
    public CreditLineFailException() {
        super();
    }

    public CreditLineFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreditLineFailException(String message) {
        super(message);
    }

    public CreditLineFailException(Throwable cause) {
        super(cause);
    }
}