package com.mstar.backend_template.config;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mstar.backend_template.common.ApiErrorResponse;
import com.mstar.backend_template.your_application.error.TestDataNotFoundException;

import lombok.extern.slf4j.Slf4j;

// 전역에서 발생하는 예외를 처리하기 위한 클래스
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(TestDataNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleTestDataNotFound(TestDataNotFoundException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage("Test data not found");
        errorResponse.setErrorDetails(ex.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiErrorResponse> handleAuthenticationException(AuthenticationException ex) {
        log.info("로그인 실패");
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage("Login failed");
        errorResponse.setErrorDetails("존재하지 않는 아이디 또는 비밀번호입니다.");
        return ResponseEntity.status(403).body(errorResponse);
    }
}
