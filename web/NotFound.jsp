<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>NotFound</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>
    <jsp:include page="navigatie.jsp">
        <jsp:param name="actual" value=""/>
    </jsp:include>

    <h1>Sorry! the item you were looking for does not exist.</h1>


</header>

<jsp:include page="footer.jsp"/>

</body>
</html>
