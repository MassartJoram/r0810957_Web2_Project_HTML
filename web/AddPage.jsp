<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Items</title>
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
        <h2>Add items to the store</h2>
    </article>
</main>



<fieldset>
        <label for="nameItem"> Name:</label>
        <input type="text" id="nameItem" name="nameItem"><br><br>
        <label for="typeItem">Type:</label>
        <input type="text" id="typeItem" name="typeItem"><br><br>
        <label for="amount"> Amount:</label>
        <input type="number" id="amount" name="amount"><br><br>
        <label for="discription">Disciption:</label>
        <textarea id="discription" name="discription" rows="4" cols="50"></textarea><br><br>
        <input class="ButtonItem" type="submit" value="Add item">
</fieldset>


    <footer class="footer">
        <p>Massart Joram: Project Web2</p>
    </footer>

</body>
</html>
