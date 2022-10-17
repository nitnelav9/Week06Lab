<%-- 
    Document   : register
    Created on : 12-Oct-2022, 10:58:23 AM
    Author     : valentinmorales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to ShoppingList</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form  action="ShoppingList" method="post">
            <input type="text" name="username">
            <input type="submit" value="Register Name">
            <input type="hidden" name="action" value="register">
        </form>
    </body>
</html>
