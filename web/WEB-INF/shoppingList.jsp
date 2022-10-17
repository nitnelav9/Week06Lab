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
        
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <p><a href="ShoppingList?logout"> Logout</a></p>
        
        
        <h1>List</h1>
        <form action="ShoppingList" method="post">
            Add Item: <input type="text" name="item" value="">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <form action="ShoppingList" method="post">
            <c:forEach items="${items}" var="item"> 
                <ul> 
                    <li><input type="radio" name="item" value="${item}">${item}</li>
                </ul>
            </c:forEach>
       
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
