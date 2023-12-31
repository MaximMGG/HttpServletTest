package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;

import com.httpservlet.test.httpservlets.servlet.dto.UserDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = (UserDto) session.getAttribute(USER);
        if (user == null) {
            user = UserDto.builder()
                            .id(100)
                            .name("Petr@gmail.com")
                            .build();
            session.setAttribute(USER, user);
        }
    }
    
}
