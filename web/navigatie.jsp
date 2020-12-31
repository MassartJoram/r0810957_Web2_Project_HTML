<header>
    <nav>
        <ul>
            <li ${param.actual eq 'Home'?"id = actual" : ""}>
                <a class="active" href="Servlet">Home</a>
            </li>
            <li ${param.actual eq 'SearchItem'?"id = actual" : ""}>
                <a href="SearchItem.jsp">Search item</a>
            </li>
            <li ${param.actual eq 'AddPage'?"id = actual" : ""}>
                <a href="AddPage.jsp">Add item</a>
            </li>
            <li ${param.actual eq 'OverviewPage'?"id = actual" : ""}>
                <a href="Servlet?command=overview">Overview</a>
            </li>
            <li ${param.actual eq 'Logbook'?"id = actual" : ""}>
                <a href="Servlet?command=logBook">Logbook</a>
            </li>
        </ul>
    </nav>
</header>
