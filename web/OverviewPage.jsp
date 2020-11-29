<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<jsp:include page="navigatie.jsp">
    <jsp:param name="actual" value="Overview"/>
</jsp:include>

<main>
    <article>

        <c:choose>
            <c:when test="${not empty items}">
                <h2>Overview of items in the store</h2>

            <table style="width:100%">
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Amount</th>
                    <th>Discription</th>
                    <th>Delete/Edit</th>
                </tr>

                <c:forEach var="items" items="${items}">
                    <tr>
                        <td>${items.name}</td>
                        <td>${items.type}</td>
                        <td>${items.amount}</td>
                        <td>${items.discription}</td>
                        <td><a href="Servlet?command=delete&name=${items.name}&type=${items.type}">Delete</a> //
                            <a href="Servlet?command=edit&name=${items.name}&type=${items.type}&amount=${items.amount}&discription=${items.discription}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
            </c:when>
                <c:otherwise>
                    <p>There are currently no items</p>
                </c:otherwise>
        </c:choose>


        <p class="paragraafC">The total amount of items is ${total}</p>


    </article>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>
