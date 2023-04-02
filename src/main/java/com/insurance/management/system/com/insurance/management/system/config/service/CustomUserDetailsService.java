package com.insurance.management.system.com.insurance.management.system.config.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("testABC")) {
            return new User("testABC", "test123", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
