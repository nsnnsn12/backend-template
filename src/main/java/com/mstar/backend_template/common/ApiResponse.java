package com.mstar.backend_template.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//정상적인 응답을 일관된 Json 형태로 응답하기 위한 클래스
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private String message;
    private T data;
}
