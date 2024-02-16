package com.estore.user.service;

import com.estore.user.dao.AuthenticationResponse;
import com.estore.user.dao.LoginRequest;
import com.estore.user.entity.UserEntity;
import com.estore.user.repository.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
@Data
public class AuthenticationService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthenticationResponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
        UserEntity byUserName = userRepo.findByUserName(loginRequest.getUserName()).orElseThrow();
        String jwtToken = jwtService.generateToken(byUserName);
        return AuthenticationResponse.builder().token(jwtToken).build();
        /*The authenticate method is called on the authenticationManager with the UsernamePasswordAuthenticationToken.
          Internally, Spring Security delegates the authentication process to a configured UserDetailsService.
          The UserDetailsService loads user details (including the password) based on the provided username.
          If the user is found and the password matches, authentication is successful. If not, an exception is thrown.*/
    }
    public AuthenticationResponse register(UserEntity user){
        UserEntity userEntity = userRepo.save(user);
        String jwtToken = jwtService.generateToken(userEntity);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }
}
