package dev.sunil.EcomUserAuthService.exception;

import dev.sunil.EcomUserAuthService.dto.ExceptionHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoleExceptionHandler {

   @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity roleNotFoundExceptionHandler(RoleNotFoundException r){
       ExceptionHandlerDTO exceptionHandlerDTO = new ExceptionHandlerDTO(r.getMessage(),404);
       return new ResponseEntity<>(exceptionHandlerDTO,HttpStatus.NOT_FOUND);
   }
}
