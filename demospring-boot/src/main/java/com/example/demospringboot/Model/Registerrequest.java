package com.example.demospringboot.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registerrequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
