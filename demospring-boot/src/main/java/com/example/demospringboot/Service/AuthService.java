package com.example.demospringboot.Service;

import com.example.demospringboot.Config.JwtService;
import com.example.demospringboot.Entity.Department;
import com.example.demospringboot.Entity.Role;
import com.example.demospringboot.Model.AuthenticateResponse;
import com.example.demospringboot.Model.Authenticaterequest;
import com.example.demospringboot.Model.Registerrequest;
import com.example.demospringboot.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public AuthenticateResponse Register(Registerrequest request) {
        var dep = Department.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        departmentRepository.save(dep);
        var jwttoken = jwtService.generatetoken(dep);
        return AuthenticateResponse.builder()
                .token(jwttoken)
                .build();
    }

    public AuthenticateResponse Authenticate(Authenticaterequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var dep = departmentRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwttoken = jwtService.generatetoken(dep);
        return AuthenticateResponse.builder()
                .token(jwttoken)
                .build();
    }


}
