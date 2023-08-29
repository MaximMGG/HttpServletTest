package com.httpservlet.test.httpservlets.servlet.mapper;

import com.httpservlet.test.httpservlets.servlet.dto.UserDto;
import com.httpservlet.test.httpservlets.servlet.entity.User;

public class UserMapper implements Mapper<User, UserDto> {

    private static final UserMapper INSTANCE = new UserMapper();

    private UserMapper() {}

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }


    public static UserMapper getInstance() {
        return INSTANCE;
    }
    
}
