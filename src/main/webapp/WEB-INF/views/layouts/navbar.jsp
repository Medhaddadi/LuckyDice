<jsp:include page="header.jsp" />
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-lg p-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Lucky Dice</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div>
        </div>

        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/players">Players</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/play">Play new Game </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/profile">Best Scores</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li><a class="dropdown-item m-2 border-2 border-danger" href="${pageContext.request.contextPath}/profile">Profile</a></li>
                <li><a class="dropdown-item  m-2 " href="${pageContext.request.contextPath}/Logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
