package com.httpservlet.test.httpservlets.servlet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.httpservlet.test.httpservlets.servlet.entity.Gender;
import com.httpservlet.test.httpservlets.servlet.entity.Role;
import com.httpservlet.test.httpservlets.servlet.entity.User;
import com.httpservlet.test.httpservlets.servlet.utils.ConnectionManager;

import lombok.SneakyThrows;


public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();

    private UserDao(){}

    private static final String SAVE_SQL = "INSERT INTO users(name, birthday, email, password, role, gender, image) values" + 
                                "(?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL = "SELECT * FROM users WHERE email = ? AND password = ?";
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
            prStatement.setObject(7, entity.getImage());

            prStatement.executeUpdate();

            ResultSet generatedKeys = prStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));
            return entity;
        }
    }

    @SneakyThrows
    public static Optional<User> findByEmaillAndPassword(String email, String password) throws SQLException {
        try (Connection connection = ConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;

            if (resultSet.next()) {
                    return Optional.ofNullable(user = buildEntity(resultSet));
            }
        }
        return Optional.empty();
    }
    private static User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .image(resultSet.getObject("image", String.class))
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.find(resultSet.getObject("role", String.class)).orElse(null))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
        .build();
    }
    
}
