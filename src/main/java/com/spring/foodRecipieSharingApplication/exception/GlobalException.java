package com.spring.foodRecipieSharingApplication.exception;

import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> dataNotFoundException(DataNotFoundException dataNotFoundException)
    {
        ResponseStructure<String> responseStructure=new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(dataNotFoundException.getMessage());
        responseStructure.setData("Data is Not Found");
        return new ResponseEntity<>(responseStructure,HttpStatus.NOT_FOUND);
    }
}
