package com.bookshop.exception;

public class CreateOrderException extends RuntimeException {
    public CreateOrderException(String message) {
        super(message);
    }

    public CreateOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
