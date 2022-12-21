package com.team2.his.controller.auth;

import com.team2.his.entitis.Account;
import com.team2.his.model.ResponseModel;
import com.team2.his.model.auth.JwtAuthenticationResponse;
import com.team2.his.model.auth.LoginRequest;
import com.team2.his.model.auth.RegisterRequest;
import com.team2.his.security.JwtTokenProvider;
import com.team2.his.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final JwtTokenProvider tokenProvider;

    @PostMapping("/signin/teacher")
    public ResponseEntity<?> authenticateUserTeacher(@Valid @RequestBody LoginRequest request) {
        long start = System.currentTimeMillis();
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword()));
            Account account = authService.getAccountInfoByLoginId(request.getLoginId());
            if (account == null){
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            String jwt = tokenProvider.generateToken(authenticate);
            long end = System.currentTimeMillis();
            long diff = end - start;
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, account));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerTeacher( @Valid @RequestBody RegisterRequest request) {
        long start = System.currentTimeMillis();
        ResponseModel model = authService.register(request);
        long end = System.currentTimeMillis();
        long diff = end - start;
        return new ResponseEntity(model.getData(), model.getResponseStatus());
    }

}
