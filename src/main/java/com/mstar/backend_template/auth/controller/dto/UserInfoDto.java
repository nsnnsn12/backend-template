package com.mstar.backend_template.auth.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInfoDto {
    private String username;
    private String role;
    private String hp;
    private String email;
}
