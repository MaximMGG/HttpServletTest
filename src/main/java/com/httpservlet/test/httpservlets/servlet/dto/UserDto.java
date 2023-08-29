package com.httpservlet.test.httpservlets.servlet.dto;

import java.time.LocalDate;

import com.httpservlet.test.httpservlets.servlet.entity.Gender;
import com.httpservlet.test.httpservlets.servlet.entity.Role;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    Integer id;
    String email;
    String name;
    LocalDate birthday;
    String image;
    Role role;
    Gender gender;
}
