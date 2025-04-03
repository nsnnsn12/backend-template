package com.mstar.backend_template.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mstar.backend_template.common.ApiErrorResponse;
import com.mstar.backend_template.your_application.error.TestDataNotFoundException;

// 전역에서 발생하는 예외를 처리하기 위한 클래스
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TestDataNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleTestDataNotFound(TestDataNotFoundException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setStatusCode(404);
        errorResponse.setMessage("Test data not found");
        errorResponse.setErrorDetails(ex.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }
}
