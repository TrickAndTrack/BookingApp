package com.bookingApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptions {



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> mainException(Exception ex, WebRequest web){

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setLct(LocalDateTime.now());
        errorDetails.setDesc(web.getDescription(false));
        errorDetails.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> noArgumentExceptionHandler(MethodArgumentNotValidException ex,WebRequest web){

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setLct(LocalDateTime.now());
        errorDetails.setDesc(web.getDescription(false));
        errorDetails.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_GATEWAY);

    }
    @ExceptionHandler(BookingException.class)
    public ResponseEntity<ErrorDetails> movieExceptionHandler(BookingException ex,WebRequest web){

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setLct(LocalDateTime.now());
        errorDetails.setDesc(web.getDescription(false));
        errorDetails.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_GATEWAY);

    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> ratingExceptionHandler(UserException ex,WebRequest web){

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setLct(LocalDateTime.now());
        errorDetails.setDesc(web.getDescription(false));
        errorDetails.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_GATEWAY);

    }
}
