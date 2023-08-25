package com.httpservlet.test.httpservlets.servlet.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String name;
    private LocalDate birthday;
    private String email;
    private String password;
    private Role role;
    private Gender gender;

}
