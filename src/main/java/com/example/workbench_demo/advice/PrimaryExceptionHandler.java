package com.example.workbench_demo.advice;

import com.example.workbench_demo.dto.response.ExceptionResponse;
import com.example.workbench_demo.exception.NotMemberOfGivenEngagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@RestControllerAdvice
public class PrimaryExceptionHandler {
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(
            IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                400, e.getMessage(), e.getMessage(), 400, Collections.emptyList()));
    }

    @ExceptionHandler(value = NotMemberOfGivenEngagement.class)
    public ResponseEntity<ExceptionResponse> handleNotMemberOfGivenEngagement(
            NotMemberOfGivenEngagement e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionResponse(
                403, e.getMessage(), e.getMessage(), 403, Collections.emptyList()));
    }

}
