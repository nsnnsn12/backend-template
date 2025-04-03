package com.mstar.backend_template.your_application.error;

public class TestDataNotFoundException extends RuntimeException {
    public TestDataNotFoundException(Long id) {
        super(String.format("Could not find employee %d", id));
    }
}
