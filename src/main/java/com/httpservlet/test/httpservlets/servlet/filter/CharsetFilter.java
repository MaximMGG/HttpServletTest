package com.httpservlet.test.httpservlets.servlet.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(value = "/*", servletNames = {
        "RegistrationServlet"
}, initParams = {
        @WebInitParam(name = "param1", value = "paramValue")
}, dispatcherTypes = DispatcherType.REQUEST)
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        chain.doFilter(request, response);
        System.out.println();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
}
