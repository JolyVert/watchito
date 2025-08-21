package com.jolyvert.watchito.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    boolean existsByEmail(String email);
}
