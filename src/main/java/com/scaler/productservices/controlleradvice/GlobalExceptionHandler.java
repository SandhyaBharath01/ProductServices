package com.scaler.productservices.controlleradvice;

import com.scaler.productservices.dtos.ExceptionDto;
import com.scaler.productservices.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Arithmetic Exception
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("ArithmeticException has Happened");
        exceptionDto.setSolution("Please try again");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
    //Array Index Out Of Bound Exception
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException has Happened, in controllerAdvice",
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
    //Product Not found Exception
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product Not Found");
        exceptionDto.setSolution("Try again with another product");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

}
