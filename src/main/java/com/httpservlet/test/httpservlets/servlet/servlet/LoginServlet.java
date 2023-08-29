package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;

import com.httpservlet.test.httpservlets.servlet.dto.UserDto;
import com.httpservlet.test.httpservlets.servlet.service.UserService;
import com.httpservlet.test.httpservlets.servlet.utils.JspHelper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            userService.login(req.getParameter("email"), req.getParameter("password"))
            .ifPresentOrElse(
                user -> onLoginSuccess(user, req, resp),
                () -> onLoginFail(req, resp)
            );
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/httpservlets-1.0-SNAPSHOT/login?error&email=" + req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(UserDto user, HttpServletRequest req, HttpServletResponse resp) {
                    req.getSession().setAttribute("user", user);
                    resp.sendRedirect("/httpservlets-1.0-SNAPSHOT/flights");
    }
    
}
