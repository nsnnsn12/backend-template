package com.mstar.backend_template.your_application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mstar.backend_template.common.ApiResponse;
import com.mstar.backend_template.your_application.error.TestDataNotFoundException;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello/{id}")
    public ResponseEntity<ApiResponse<String>> hello(@PathVariable Long id) {
        if (id == 0) {
            throw new TestDataNotFoundException(id);
        }
        ApiResponse<String> response = ApiResponse
        .<String>builder()
        .data("Hello, World!")
        .statusCode(200)
        .message("Hello, World! 조회 성공")
        .build();
        return ResponseEntity.ok(response);
    }
}
