package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;
import java.util.List;

import com.httpservlet.test.httpservlets.servlet.dto.CreateUserDto;
import com.httpservlet.test.httpservlets.servlet.exception.ValidationException;
import com.httpservlet.test.httpservlets.servlet.service.UserService;
import com.httpservlet.test.httpservlets.servlet.utils.JspHelper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserDto userDto = CreateUserDto.builder()
                    .name(req.getParameter("name"))
                    .birthday(req.getParameter("birthday"))
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .role(req.getParameter("role"))
                    .gender(req.getParameter("gender"))
                    .build();

        try {
        userService.create(userDto);
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrors());
            doGet(req, resp);
        }
        resp.sendRedirect("/httpservlets-1.0-SNAPSHOT/login");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", List.of("USER", "ADMIN"));
        req.setAttribute("genders", List.of("MALE", "FEMALE"));

        req.getRequestDispatcher(JspHelper.getPath("registration")).forward(req, resp);
    }

    
    
}
