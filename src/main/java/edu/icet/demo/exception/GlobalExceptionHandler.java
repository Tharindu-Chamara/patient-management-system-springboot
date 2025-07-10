package edu.icet.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

       @ExceptionHandler(EmailAlreadyExistsException.class)
       ResponseEntity<String> handleValidationException(EmailAlreadyExistsException exception){
           log.warn("Email all ready exist {}", exception.getMessage());
           return   ResponseEntity.badRequest().body(exception.getMessage());
        }
        @ExceptionHandler(PatientNotFoundException.class)
        ResponseEntity<Map<String,String>> patientNotFoundException(PatientNotFoundException exception){

           Map<String,String> errors =  new HashMap<>();
           errors.put("message","Patient not found");
           log.info("patient not found {}",exception.getMessage());
           return ResponseEntity.badRequest().body(errors);


        }
}
