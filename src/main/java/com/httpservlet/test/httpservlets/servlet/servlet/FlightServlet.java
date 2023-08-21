package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;

import com.httpservlet.test.httpservlets.servlet.service.FlightService;
import com.httpservlet.test.httpservlets.servlet.utils.JspHelper;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet{

    private final FlightService flightService = FlightService.getIstance();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flights", flightService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("flights")).forward(req, resp);
    }
    

}
