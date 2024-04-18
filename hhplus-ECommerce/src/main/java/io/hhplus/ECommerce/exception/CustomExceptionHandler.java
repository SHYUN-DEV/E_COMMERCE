package io.hhplus.ECommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  
    @ExceptionHandler(InsufficientInventoryException.class)
    public ResponseEntity<Object> handleInsufficientInventoryException(InsufficientInventoryException ex) {
        // 상품 재고 부족 예외 처리 
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NotEnoughPointException.class)
    public ResponseEntity<Object> handleNotEnoughPointException(NotEnoughPointException ex) {
        // 포인트 부족 예외 처리 
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    

    public class ErrorResponse {
        private HttpStatus status;
    
        private String debugMessage;

        public ErrorResponse(HttpStatus status, String debugMessage) {
            this.status = status;
            this.debugMessage = debugMessage;
        }

        // Getter와 Setter 메서드
    }
}
