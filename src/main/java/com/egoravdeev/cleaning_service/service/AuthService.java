package com.egoravdeev.cleaning_service.service;

import com.egoravdeev.cleaning_service.dto.JwtRequest;
import com.egoravdeev.cleaning_service.dto.JwtResponse;
import com.egoravdeev.cleaning_service.dto.RegistrationUserDto;
import com.egoravdeev.cleaning_service.exceptions.AppError;
import com.egoravdeev.cleaning_service.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createAuthToken(JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(RegistrationUserDto registrationUserDto) {
        if (userService.findByLogin(registrationUserDto.getLogin()).isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с таким логином уже существует"), HttpStatus.BAD_REQUEST);
        }
        userService.createdNewUser(registrationUserDto);

        var request = new JwtRequest();
        request.setUsername(registrationUserDto.getLogin());
        request.setPassword(registrationUserDto.getPassword());

        return ResponseEntity.ok(createAuthToken(request));
    }
}
