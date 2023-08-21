package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.httpservlet.test.httpservlets.servlet.dto.FlightDto;
import com.httpservlet.test.httpservlets.servlet.service.FlightService;
import com.httpservlet.test.httpservlets.servlet.utils.JspHelper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getIstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FlightDto> flightDtos = flightService.findAll();

        req.setAttribute("flights", flightDtos);
        req.getSession().setAttribute("flightsMap", flightDtos.stream()
                            .collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));

        req.getRequestDispatcher(JspHelper.getPath("content")).forward(req, resp);

    }

     
    
}
