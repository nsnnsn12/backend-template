package com.mstar.backend_template.common;

import lombok.Getter;
import lombok.Setter;

//에러를 일관된 Json 형태로 응답하기 위한 클래스
@Getter
@Setter
public class ApiErrorResponse {
    private int statusCode;
    private String message;
    private String errorDetails;
}
