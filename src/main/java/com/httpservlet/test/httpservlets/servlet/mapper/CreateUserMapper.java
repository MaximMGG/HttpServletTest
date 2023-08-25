package com.httpservlet.test.httpservlets.servlet.mapper;

import com.httpservlet.test.httpservlets.servlet.dto.CreateUserDto;
import com.httpservlet.test.httpservlets.servlet.entity.Gender;
import com.httpservlet.test.httpservlets.servlet.entity.Role;
import com.httpservlet.test.httpservlets.servlet.entity.User;
import com.httpservlet.test.httpservlets.servlet.utils.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                    .name(object.getName())
                    .birthday(LocalDateFormatter.format(object.getBirthday()))
                    .email(object.getEmail())
                    .password(object.getPassword())
                    .gender(Gender.valueOf(object.getGender()))
                    .role(Role.valueOf(object.getRole()))
                    .build();

    }

    public static CreateUserMapper getInstane() {
        return INSTANCE;
    }
    
}
