
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <form action="${pageContext.request.contextPath}/login" method ="post">
            <lable for="email"><fmt:message key="page.login.email" />
                <input type="text" name="email" id="email" value="${param.email}" required>
        </lable><br>
            <lable for="password"><fmt:message key="page.login.password"/>
                <input type="password" name="password" id="password" required>
            </lable><br>
            <button type="submit"><fmt:message key="page.login.submit.button"/></button>
                <a href="${pageContext.request.contextPath}/registration">
                    <button tepe="button"><fmt:message key="page.login.register.button"/></button>
                </a>
                <c:if test="${param.error != null}">
                    <div style="color : red">
                        <span><fmt:message key="page.login.error"/></span>
                    </div>
                </c:if>
        </form>
    </body>
</html>