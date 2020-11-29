<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<jsp:include page="navigatie.jsp">
    <jsp:param name="actual" value=""/>
</jsp:include>

<main>
    <article>
        <h2>Deleting item</h2>

        <p> Are you sure you want to delete ${items.name} ${items.type} ?</p>

        <form action="Servlet?command=deleteConfirm" method="POST">
            <input type="hidden" name="name" value="${items.name}">
            <input type="hidden" name="type" value="${items.type}">
            <input type="submit" value="Sure" name="submit">
            <input type="submit" value="Not yet" name="submit">
        </form>
    </article>
</main>

<jsp:include page="footer.jsp"/>


</body>
</html>
