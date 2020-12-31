<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Logbook</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<jsp:include page="navigatie.jsp">
    <jsp:param name="actual" value="Logbook"/>
</jsp:include>

<main>
    <article>

        <c:choose>
            <c:when test="${not empty events}">
                <h2>Logbook</h2>

                <table style="width:100%">
                    <tr>
                        <th>Time Added</th>
                        <th>Item Name</th>

                    </tr>

                    <c:forEach var="events" items="${events}">
                        <tr>
                            <td>${events.localTime}</td>
                            <td>${events.pages}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>There is nothing in the log</p>
            </c:otherwise>
        </c:choose>


    </article>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>