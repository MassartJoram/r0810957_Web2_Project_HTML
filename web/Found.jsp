<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="Domain.Model.Items" %>

<% Items items= (Items) request.getAttribute("items"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Found</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
<header>
    <div>
        <nav>
            <ul>
                <li><a class="active" href="Servlet">Home</a></li>
                <li><a href="SearchItem.jsp">Search item</a></li>
                <li><a href="AddPage.jsp">Add item</a></li>
                <li><a href="Servlet?command=overview">Overview</a></li>
            </ul>
        </nav>
    </div>
    <h1>Item found!</h1>


</header>
<main>
    <p>You looked for : <%= items.getName()%><%= items.getType()%></p>
</main>

</body>
</html>