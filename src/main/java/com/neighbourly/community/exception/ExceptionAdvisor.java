package com.neighbourly.community.exception;

import com.neighbourly.community.dto.Error;
import com.neighbourly.community.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvisor {

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Response<Error>> handleMissingRequestHeaderException(MissingRequestHeaderException e) {
        Error error = new Error();
        error.setErrorCode("400");
        error.setErrorMessage("Missing required header: " + e.getHeaderName());
        Response<Error> response = Response.<Error>builder().data(error).build();
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(CommunityNotFoundException.class)
    public ResponseEntity<Response<Error>> handleMissingRequestHeaderException(CommunityNotFoundException e) {
        Error error = new Error();
        error.setErrorCode("400");
        error.setErrorMessage(e.getMessage());
        Response<Error> response = Response.<Error>builder().data(error).build();
        return ResponseEntity.badRequest().body(response);
    }


}
