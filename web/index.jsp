<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
  </head>

  <body>

  <header>

    <jsp:include page="navigatie.jsp">
      <jsp:param name="actual" value="Home"/>
    </jsp:include>

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


          <p class="paragraafC">The total amount of items is ${total}</p>


    </article>
  </main>

  <jsp:include page="footer.jsp"/>

  </body>
</html>
