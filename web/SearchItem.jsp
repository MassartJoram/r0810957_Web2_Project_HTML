<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Items</title>
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

    <h2>Search for an item</h2>

</header>

<main>
    <article>
        <form method="Get" action="Servlet" novalidate>
            <fieldset>
                <p>
                    <label for="name"> Name: </label>
                    <input id="name" name="name" type="text" value="" required>
                </p>

                <p>
                    <label for="type"> Type:</label>
                    <input id="type" name="type" , type="text" value="" required>
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


    <footer class="footer">
        <p>Massart Joram: Project Web2</p>
    </footer>

</body>
</html>
