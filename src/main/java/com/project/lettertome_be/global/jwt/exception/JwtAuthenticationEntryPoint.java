package com.project.lettertome_be.global.jwt.exception;

import com.project.lettertome_be.global.common.util.HttpResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        SecurityErrorCode errorCode = SecurityErrorCode.UNAUTHORIZED;
        HttpResponseUtil.setErrorResponse(response, errorCode.getHttpStatus(), errorCode.getErrorResponse());
    }
}

