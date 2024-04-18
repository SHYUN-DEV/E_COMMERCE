package io.hhplus.ECommerce.exception;

public class NotEnoughPointException extends RuntimeException {

    public NotEnoughPointException(String message) {
        super(message);
    }

    public NotEnoughPointException(String message, Throwable cause) {
        super(message, cause);
    }
}
