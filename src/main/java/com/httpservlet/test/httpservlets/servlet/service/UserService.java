package com.httpservlet.test.httpservlets.servlet.service;

import com.httpservlet.test.httpservlets.servlet.dao.UserDao;
import com.httpservlet.test.httpservlets.servlet.dto.CreateUserDto;
import com.httpservlet.test.httpservlets.servlet.entity.User;
import com.httpservlet.test.httpservlets.servlet.exception.ValidationException;
import com.httpservlet.test.httpservlets.servlet.mapper.CreateUserMapper;
import com.httpservlet.test.httpservlets.servlet.validator.CreateUserValidator;
import com.httpservlet.test.httpservlets.servlet.validator.ValidationResult;

public class UserService {
    
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstane();

    public Integer create(CreateUserDto userDto) {
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        User userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }


    public static UserService getInstance() {
        return INSTANCE;
    }
}