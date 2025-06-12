package com.maketmall.demo.controller;

import com.maketmall.demo.dto.LoginRequest;
import com.maketmall.demo.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // 1. 아이디/비밀번호 기반 인증 시도
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            // 2. 인증 성공 → JWT 생성
            String token = jwtTokenProvider.createToken(
                    authentication.getName(), // = email
                    authentication.getAuthorities().iterator().next().getAuthority() // ex: ROLE_USER
            );

            // 3. 응답으로 토큰 반환
            return ResponseEntity.ok().body(token);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("로그인 실패: 이메일 또는 비밀번호를 확인하세요.");
        }
    }
}
