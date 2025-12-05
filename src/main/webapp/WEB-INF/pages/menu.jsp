<header data-bs-theme="dark">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}">Parking Lot</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
                <li class = "nav-link">
                    <a class="nav-link ${pageContext.request.requestURI.endsWith('/about.jsp') ? 'active' : ''}"
                       href="${pageContext.request.contextPath}/about.jsp"
                       aria-current = "${pageContext.request.requestURI.endsWith('/about.jsp') ? 'page' : ''}">
                        About
                    </a>
                </li>

                <li class="nav-item">
                    <a class = "nav-link ${activePage == 'Cars' ? 'active' : ''}"
                       href = "${pageContext.request.contextPath}/Cars"
                       aria-current="${activePage == 'Cars' ? 'page' : ''}">
                        Cars
                    </a>
                </li>


                <li class="nav-item">
                    <a class="nav-link">
                        Users
                    </a>
                </li>
            </ul>
            <ul class = "navbar-nav">
                <li class = "nav-item">
                    <a class = "nav-link" href = "${pageContext.request.contextPath}/Login">
                        Login
                    </a>
                </li>

            </ul>


        </div>
        </div>
    </nav>
</header>