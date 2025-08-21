package com.jolyvert.watchito.service;

import com.jolyvert.watchito.dto.AuthenticationResponseDto;
import com.jolyvert.watchito.dto.LoginRequestDto;
import com.jolyvert.watchito.dto.RegistrationRequestDto;
import com.jolyvert.watchito.exception.LoginException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;


public interface AuthenticationService {

    public void register(RegistrationRequestDto request) throws LoginException;
    public AuthenticationResponseDto authenticate(LoginRequestDto loginDto);
    public ResponseEntity<AuthenticationResponseDto> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response);

}
