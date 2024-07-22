package dev.sunil.EcomUserAuthService.exception;

import dev.sunil.EcomUserAuthService.dto.ExceptionHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity handleEmailAlreadyExistsException(EmailAlreadyExistException e){
        ExceptionHandlerDTO ed = new ExceptionHandlerDTO(e.getMessage(),
                400);
        return new  ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }
}
