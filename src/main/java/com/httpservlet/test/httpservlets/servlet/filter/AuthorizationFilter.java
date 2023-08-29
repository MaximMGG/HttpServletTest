package com.httpservlet.test.httpservlets.servlet.filter;

import java.io.IOException;
import java.util.Set;

import com.httpservlet.test.httpservlets.servlet.dto.UserDto;
import com.httpservlet.test.httpservlets.servlet.utils.UrlPath;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(UrlPath.LOGIN, UrlPath.IMAGES, UrlPath.REGISTRATION);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) request).getRequestURI();
        if (isPublicPath(uri) || isUserLoggedIn(request)) {
            chain.doFilter(request, response);
        } else {
            String prevPage = ((HttpServletRequest) request).getHeader("referer");
            ((HttpServletResponse) response).sendRedirect(prevPage != null ? prevPage : UrlPath.LOGIN);
        }
    }

    private boolean isUserLoggedIn(ServletRequest request) {
        UserDto user = (UserDto) ((HttpServletRequest)request).getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);
    }
    
}
