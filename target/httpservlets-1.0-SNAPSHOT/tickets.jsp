<%@ page import="com.httpservlet.test.httpservlets.servlet.service.TicketService" %>
<%@ page import="com.httpservlet.test.httpservlets.servlet.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%!
            public void jspInit() {
                System.out.println("Hello world!");
            }
        %>
        <h1>Bought tickets: </h1>
        <ul>
            <%
                Long flightId = Long.valueOf(request.getParameter("flightId"));
                List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
                for (TicketDto ticket : tickets) {
                    out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
                }
            %>

        </ul>
        <%

        %>
    </body>
</html>