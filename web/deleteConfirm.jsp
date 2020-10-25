<%@ page import="Domain.Model.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Items items= (Items) request.getAttribute("items"); %>

<html>
<head>
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>
    <nav>
        <ul>
            <li><a class="active" href="Servlet">Home</a></li>
            <li><a href="SearchItem.jsp">Search item</a></li>
            <li><a href="AddPage.jsp">Add item</a></li>
            <li><a href="Servlet?command=overview">Overview</a></li>
        </ul>
    </nav>
</header>

<main>
    <article>
        <h2>Deleting item</h2>

        <p> Are you sure you want to delete <%= items.getName()%> <%= items.getType()%> ?</p>

        <form action="Servlet?command=deleteConfirm" method="POST">
            <input type="hidden" name="name" value="<%= items.getName()%>">
            <input type="hidden" name="type" value="<%= items.getType()%>">
            <input type="submit" value="Sure" name="submit">
            <input type="submit" value="Not yet" name="submit">
        </form>
    </article>
</main>
</body>
</html>
