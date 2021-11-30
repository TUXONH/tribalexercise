package com.tribal.exceptions;

public class RequestLimitException extends RuntimeException {
    public RequestLimitException() {
        super();
    }

    public RequestLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestLimitException(String message) {
        super(message);
    }

    public RequestLimitException(Throwable cause) {
        super(cause);
    }
}
