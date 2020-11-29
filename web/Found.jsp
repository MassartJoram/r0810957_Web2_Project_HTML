<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Found</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
<header>
    <div>
        <jsp:include page="navigatie.jsp">
            <jsp:param name="actual" value=""/>
        </jsp:include>
    </div>
    <h1>Item found!</h1>


</header>
<main>
    <p>You looked for : ${items.name} , ${items.type}</p>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>