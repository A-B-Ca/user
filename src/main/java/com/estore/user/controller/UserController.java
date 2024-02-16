package com.estore.user.controller;

import com.estore.user.dao.AuthenticationResponse;
import com.estore.user.dao.LoginRequest;
import com.estore.user.entity.UserEntity;
import com.estore.user.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
   /* @Autowired
    private UserService userService;*/
    @Autowired
    private AuthenticationService authService;
    @PostMapping("jwt/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @PostMapping("jwt/register")
    public ResponseEntity<AuthenticationResponse> add(@RequestBody UserEntity user){

        return ResponseEntity.ok(authService.register(user));
    }
    @GetMapping("/loggedin")
    public ResponseEntity<String> loggedIn(){
        return ResponseEntity.ok("WELCOME TO e-Store!!");
    }

}
