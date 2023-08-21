<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div>
            <span>Content. Hello</span>
            <p>Size: ${requestScope.flights.size()}</p>
            <p>Id: ${requestScope.flights.get(0).id}</p>
            <p>Id 2: ${requestScope.flights[1].id}</p>
            <p>Map Id: ${requestScope.flightsMap[1]}</p>
            <p>JSESSION id: ${cookie["JSESSIONID"]}, unique identifier</p>
            <p>Header: ${header["Cookie"]}</p>
            <p>Param id: ${param.id}</p>
            <p>Param test: ${param.test}</p>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>