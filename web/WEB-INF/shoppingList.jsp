<%-- 
    Document   : shoppingList
    Created on : 12-Oct-2022, 10:58:40 AM
    Author     : valentinmorales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to ShoppingList</title>
    </head>
    <body>
        <form action="" method="post">
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <p><a href="ShoppingList?action=logout"> Logout</a></p>
        </form>
        
        <h1>List</h1>
        <form action="" method="post">
            Add Item: <input type="text" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
            <c:forEach items="${items}" var="item"> 
                <ul> 
                    <li><input type="radio" name="item" value="${item}">${item}</li>
                </ul>
            </c:forEach>
        </form>
        <form>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
