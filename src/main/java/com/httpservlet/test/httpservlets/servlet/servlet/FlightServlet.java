package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import com.httpservlet.test.httpservlets.servlet.service.FlightService;

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
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Flights List:</h1>");
            writer.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
                writer.write("""
                        <li>
                            <a href="/tickets?flightId=%d">%s</a>
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription()));
            });
            writer.write("</ul>");
        }
    }
    

}
