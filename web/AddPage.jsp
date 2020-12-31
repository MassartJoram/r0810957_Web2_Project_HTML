<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Add Items</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>

    <jsp:include page="navigatie.jsp">
        <jsp:param  name="actual" value="AddPage"/>
    </jsp:include>

</header>

<main>
    <article>
        <h2>Add items to the store</h2>
    </article>
</main>



<fieldset>

    <c:if test="${not empty errors}">
        <ul>
            <c:forEach items="${errors}" var="error">
                <li>
                    ${error}
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <form action="Servlet?command=addItem&Servlet?command=logBook" method="post" novalidate>
        <p>
        <label for="name"> Name:</label>
        <input type="text" id="name" name="name" value="${namePreviousValue}">
        </p>

        <p>
        <label for="type">Type:</label>
        <input type="text" id="type" name="type" value="${typePreviousValue}">
        </p>

        <p>
        <label for="amount"> Amount:</label>
        <input type="number" id="amount" name="amount" value="${amountPreviousValue}">
        </p>

        <p>
        <label for="discription">Disciption:</label>
        <textarea id="discription" name="discription" rows="4" cols="50"></textarea>
        </p>

        <p>
        <input id="ButtonAdd" class="ButtonItem" type="submit" value="Add item">
        </p>

    </form>
</fieldset>


<jsp:include page="footer.jsp"/>

</body>
</html>
