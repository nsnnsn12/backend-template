package com.mstar.backend_template.auth.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mstar.backend_template.auth.controller.dto.UserInfoDto;
import com.mstar.backend_template.common.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
@Slf4j
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final HttpSessionSecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
            .getContextHolderStrategy();

    @PostMapping
    public ResponseEntity<ApiResponse<UserInfoDto>> login(@RequestBody LoginRequest loginRequest,
            HttpServletRequest request, HttpServletResponse response) {
        log.info("로그인 요청");
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken
                .unauthenticated(loginRequest.username(), loginRequest.password());

        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
        SecurityContext context = this.securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authenticationResponse);
        this.securityContextHolderStrategy.setContext(context);
        this.securityContextRepository.saveContext(context, request, response);

        UserInfoDto userInfo = UserInfoDto.builder()
                .username("노성규")
                .email("sunggyudev@gmail.com")
                .hp("01012341234")
                .role("admin")
                .build();
        ApiResponse<UserInfoDto> result = ApiResponse
                .<UserInfoDto>builder()
                .data(userInfo)
                .message("로그인 성공")
                .build();
        return ResponseEntity.ok(result);
    }

    public record LoginRequest(String username, String password) {
    }
}
