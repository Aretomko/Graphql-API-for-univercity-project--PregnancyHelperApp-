package com.example.demo.security;

import com.example.demo.domen.auth.AuthenticationRequest;
import com.example.demo.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class LoginController {
    @Autowired
    CustomAuthenticationProvider authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserRepo users;


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest data) {
        String username = data.getUsername();
        UsernamePasswordAuthenticationToken tokenObject = new UsernamePasswordAuthenticationToken(username, data.getPassword());
        authenticationManager.authenticate(tokenObject);
        String token = jwtTokenProvider.createToken(username, new ArrayList<String>(Collections.singleton("USER")));
        HashMap<Object, Object> model = new HashMap<>();
        model.put("username", username);
        model.put("token", token);
        logger.info("User" + username + "has logged into the application");
        return ok(model);
    }
}
