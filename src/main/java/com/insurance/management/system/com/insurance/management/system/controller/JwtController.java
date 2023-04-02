package com.insurance.management.system.com.insurance.management.system.controller;

import com.insurance.management.system.com.insurance.management.system.config.util.JwtUtil;
import com.insurance.management.system.com.insurance.management.system.model.requestModel.JwtModel;
import com.insurance.management.system.com.insurance.management.system.model.responseModel.JwtResponse;
import com.insurance.management.system.com.insurance.management.system.model.responseModel.Status;
import com.insurance.management.system.com.insurance.management.system.model.responseModel.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtModel jwtModel) throws Exception {
        System.out.println("jwtModel  " + jwtModel);
        try {
            this.authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(jwtModel.getName(), jwtModel.getPassword()));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtModel.getName());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/validateToken", method = RequestMethod.POST)
    public ResponseEntity<?> validToken(@RequestBody ValidateToken validateToken) throws Exception {
        try {
            this.authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken((validateToken.getName()), validateToken.getPassword()));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        // fine area
        if (validateToken.getToken() == null && validateToken.getToken().isEmpty()) {
            return ResponseEntity.ok(new Status("500", "Token is not supplied!"));
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(validateToken.getName());
        boolean token = this.jwtUtil.validateToken(validateToken.getToken(), userDetails);
        String validated = "";
        if (token) {
            validated = "JWT Token successfully verified!";
            return ResponseEntity.ok(new Status("200", validated));
        } else {
            validated = "JWT token is not correct!";
            return ResponseEntity.ok(new Status("500", validated));
        }
    }
}
