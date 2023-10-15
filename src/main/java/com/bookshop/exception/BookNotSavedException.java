package com.bookshop.exception;

public class BookNotSavedException extends RuntimeException {
    public BookNotSavedException(String message, Throwable cause) {
        super(message, cause);
    }
}
