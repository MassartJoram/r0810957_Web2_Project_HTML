<%@ page import="Domain.db.ItemsDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Domain.Model.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ItemsDB itemsDB = new ItemsDB();
    ArrayList<Items> itemList;
    itemList = itemsDB.getItemList();%>

<html>
<head>
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>
<nav>
    <ul>
        <li><a class="active" href="index.jsp">Home</a></li>
        <li><a href="AddPage.jsp">Add item</a></li>
        <li><a href="OverviewPage.jsp">Overview</a></li>
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
            </tr>

            <%
                for (Items items: itemList) {
            %>
            <tr>
                <td><%=items.getName()%></td>
                <td><%=items.getType()%></td>
                <td><%=items.getAmount()%></td>
                <td><%=items.getDiscription()%></td>
            </tr>

            <%
                }
            %>
        </table>

        <p class="paragraafC">The total amount of items is <%=itemsDB.calculateTotal()%></p>

    </article>
</main>


    <footer class="footer">
        <p>Massart Joram: Project Web2</p>
    </footer>

</body>
</html>
