<%@ page import="Domain.db.ItemsDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Integer total = (Integer) request.getAttribute("total"); %>

<html>
  <head>
    <title>Home</title>
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

    <h1 class="h2Home">Welcome to the DnD store</h1>

  </header>

  <main>
    <article>
      <p class="paragraafC">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc sagittis massa non est dictum, at rhoncus sapien fringilla.
        Quisque non nisl nunc. Mauris vel molestie ipsum. Curabitur ac diam finibus justo congue consectetur.
        Vestibulum vitae malesuada nunc. Maecenas vestibulum finibus pulvinar.
        Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.
        Cras ut lacinia tellus.
      </p>
      <img src="Images/Store.jpg" class="center">

      <% if (total != null) { %>
      <p class="paragraafC">The total amount of items is <%=total%></p>
      <% } else {%>
      <p class="paragraafC">0</p>
      <% } %>

    </article>
  </main>





  <footer class="footer">
    <p>Massart Joram: Project Web2</p>
  </footer>

  </body>
</html>
