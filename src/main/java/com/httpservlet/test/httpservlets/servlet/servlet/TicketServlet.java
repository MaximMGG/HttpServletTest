package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import com.httpservlet.test.httpservlets.servlet.service.TicketService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet{

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long flightId = Long.valueOf(req.getParameter("flightId"));

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter pw = resp.getWriter()) {
            pw.write("<h1>bought tickets</h1>");
            pw.write("<ul>");
            ticketService.findAllByFlightId(flightId).forEach(ticketDto -> 
            pw.write("""
                   <li>
                        %s
                   </li>
                    """.formatted(ticketDto.getSeatNo())));
            pw.write("</ul>");

        }
    }

}
