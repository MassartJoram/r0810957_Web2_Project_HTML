<%@ page import="Domain.db.ItemsDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Domain.Model.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Integer total = (Integer) request.getAttribute("total");
    ArrayList<Items> itemList = (ArrayList<Items>) request.getAttribute("items");
%>

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
        <h2>Overview of items in the store</h2>

        <table style="width:100%">
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Discription</th>
                <th>Delete</th>
            </tr>

            <%
                for (Items items: itemList) {
            %>
            <tr>
                <td><%=items.getName()%></td>
                <td><%=items.getType()%></td>
                <td><%=items.getAmount()%></td>
                <td><%=items.getDiscription()%></td>
                <td><a href="Servlet?command=delete&name=<%=items.getName()%>&type=<%=items.getType()%>">Delete</a></td>
            </tr>

            <%
                }
            %>
        </table>


        <% if (total != null) { %>
        <p class="paragraafC">The total amount of items is <%=total%></p>
        <% } else {%>
        <p class="paragraafC">0</p>
        <% } %>

    </article>
</main>


    <footer class="footer">
        <p>Massart Joram: Project Web2</p>
    </footer>

</body>
</html>
