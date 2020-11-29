<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Edit Items</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>

    <jsp:include page="navigatie.jsp">
        <jsp:param name="actual" value=""/>
    </jsp:include>

</header>

<main>
    <article>
        <h2>Edit an item</h2>
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

    <form action="Servlet?command=editConfirm" method="post" novalidate>


        <p${name}>
            <label  for="name"> Name:</label>
            <input  type="text" id="name" name="name" value="${items.name}">
        </p>

        <p${type}">
            <label for="type">Type:</label>
            <input type="text" id="type" name="type" value="${items.type}">
        </p>

        <p ${amount}>
            <label for="amount"> Amount:</label>
            <input type="number" id="amount" name="amount" value="${items.amount}">
        </p>

        <p ${discription}>
            <label for="discription">Disciption:</label>
            <textarea id="discription" name="discription" rows="4" cols="50"></textarea>


         <p>
        <input class="ButtonItem" type="submit" value="Edit">
        </p>


    </form>
</fieldset>


<jsp:include page="footer.jsp"/>

</body>
</html>
