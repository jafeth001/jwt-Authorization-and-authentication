package com.example.demospringboot.Controller;

import com.example.demospringboot.Entity.Department;
import com.example.demospringboot.Model.AuthenticateResponse;
import com.example.demospringboot.Model.Authenticaterequest;
import com.example.demospringboot.Model.Registerrequest;
import com.example.demospringboot.Service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthenticateResponse Register(@RequestBody Registerrequest request) {
        log.info("==== inside department registration ====");
        return authService.Register(request);
    }

    @PostMapping("/authenticate")
    public AuthenticateResponse Authenticate(@RequestBody Authenticaterequest request) {
        log.info("==== inside department Authentication ====");
        return authService.Authenticate(request);
    }


}
