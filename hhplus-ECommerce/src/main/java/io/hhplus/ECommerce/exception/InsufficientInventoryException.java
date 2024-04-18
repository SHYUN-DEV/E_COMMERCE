package io.hhplus.ECommerce.exception;

public class InsufficientInventoryException extends RuntimeException {
    public InsufficientInventoryException() {
        super("Insufficient inventory for this product");
    }

    public InsufficientInventoryException(String message) {
        super(message);
    }

    public InsufficientInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
