<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Search Items</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>

<jsp:include page="navigatie.jsp">
    <jsp:param name="actual" value="Search item"/>
</jsp:include>

    <h2>Search for an item</h2>

</header>

<main>
    <article>

        <c:if test="${not empty errors}">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>
                            ${error}
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <form method="Get" action="Servlet" novalidate>
            <fieldset>
                <p${name}>
                    <label for="name"> Name: </label>
                    <input id="name" name="name" type="text" value="${namePreviousValue}">
                </p>

                <p${type}>
                    <label for="type"> Type:</label>
                    <input id="type" name="type" type="text" value="${typePreviousValue}">
                </p>

                <input type="hidden" name="command" value="findItem">

                <p>
                <label for="search">&nbsp;</label>
                <input class="buttonSearch" id="search" type="submit" value="Search item">
                </p>

            </fieldset>

        </form>
    </article>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>
