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
        <li><a class="active" href="Servlet">Home</a></li>
        <li><a href="SearchItem.jsp">Search item</a></li>
        <li><a href="AddPage.jsp">Add item</a></li>
        <li><a href="Servlet?command=overview">Overview</a></li>
    </ul>
</nav>

</header>

<main>
    <article>
        <h2>Add items to the store</h2>
    </article>
</main>



<fieldset>
    <form action="Servlet?command=addItem" method="post" novalidate>

        <label for="name"> Name:</label>
        <input type="text" id="name" name="name"><br><br>
        <label for="type">Type:</label>
        <input type="text" id="type" name="type"><br><br>
        <label for="amount"> Amount:</label>
        <input type="number" id="amount" name="amount"><br><br>
        <label for="discription">Disciption:</label>
        <textarea id="discription" name="discription" rows="4" cols="50"></textarea><br><br>
        <input class="ButtonItem" type="submit" value="Add item">

    </form>
</fieldset>


    <footer class="footer">
        <p>Massart Joram: Project Web2</p>
    </footer>

</body>
</html>
