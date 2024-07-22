package dev.sunil.EcomUserAuthService.exception;

import dev.sunil.EcomUserAuthService.dto.ExceptionHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidCredentialsExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity invalidCredentialsExceptionHandler(EmailAlreadyExistException e){
        ExceptionHandlerDTO exceptionHandlerDTO= new ExceptionHandlerDTO(e.getMessage(), 400);
        return new ResponseEntity<>(exceptionHandlerDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity invalidCredentialsExceptionHandler(InvalidCredentialsException e){
        ExceptionHandlerDTO exceptionHandlerDTO= new ExceptionHandlerDTO(e.getMessage(), 400);
        return new ResponseEntity<>(exceptionHandlerDTO, HttpStatus.BAD_REQUEST);
    }
}
