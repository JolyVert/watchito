package com.jolyvert.watchito.controller;

import com.jolyvert.watchito.dto.AuthenticationResponseDto;
import com.jolyvert.watchito.dto.LoginRequestDto;
import com.jolyvert.watchito.dto.RegistrationRequestDto;
import com.jolyvert.watchito.exception.LoginException;
import com.jolyvert.watchito.service.AuthenticationService;
import com.jolyvert.watchito.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationRequestDto registerDto) throws LoginException {


        authenticationService.register(registerDto);

        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> authenticate(
            @RequestBody LoginRequestDto loginDto) {

        return ResponseEntity.ok(authenticationService.authenticate(loginDto));
    }

    @PostMapping("/refresh_token")
    public ResponseEntity<AuthenticationResponseDto> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) {

        return authenticationService.refreshToken(request, response);
    }

}
