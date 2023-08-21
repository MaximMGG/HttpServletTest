
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="/httpservlets-1.0-SNAPSHOT/registration" method="post">
            <label for="name">Name:
                <input type="text" name="name" id="name">
            </label><br>
            <label for="birthday">Birthday:
                <input type="date" name="birthday" id="birthday">
            </label><br>
            <label for="email">Email:
                <input type="text" name="email" id="email">
            </label><br>
            <label for="password">Password:
                <input type="password" name="password" id="password">
            </label><br>
            <button type="submit">Send</button>
        </form>
    </body>
</html>