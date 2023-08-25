package com.httpservlet.test.httpservlets.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.httpservlet.test.httpservlets.servlet.entity.User;
import com.httpservlet.test.httpservlets.servlet.utils.ConnectionManager;

import lombok.SneakyThrows;


public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();

    private UserDao(){}

    private static final String SAVE_SQL = "INSERT INTO users(name, birthday, email, password, role, gender) values" + 
                                "(?, ?, ?, ?, ?, ?)";

    public static UserDao getInstance() {
        return INSTANCE;
    }
    @Override
    public List<User> findAl() {
        return null;
    }

    @Override
    public Optional<User> finndById(Integer t) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer t) {
        return false;
    }

    @Override
    public void update(User k) {
    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionManager.get();
        PreparedStatement prStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            prStatement.setObject(1, entity.getName());
            prStatement.setObject(2, entity.getBirthday());
            prStatement.setObject(3, entity.getEmail());
            prStatement.setObject(4, entity.getPassword());
            prStatement.setObject(5, entity.getRole().name());
            prStatement.setObject(6, entity.getGender().name());

            prStatement.executeUpdate();

            ResultSet generatedKeys = prStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));
            return entity;
        }
    }
    
}
