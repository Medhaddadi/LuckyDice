<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layouts/navbar.jsp" />
<div class="container m-3 w-75 m-auto">
    <div class="row pt-3">
        <div class="col-md-12 text-center">
            <h1>Players</h1>
        </div>
        <table class="table table-striped table-bordered shadow-sm">
            <thead>
            <tr class="info">
                <th>ID</th>
                <th>Login</th>
                <th>Best Score</th>
                <th>Nom</th>
                <th>Prenom</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pl" items="${requestScope.players}">
                <tr>
                    <td>${pl.id}</td>
                    <td>${pl.login}</td>
                    <td>${pl.bestScore}</td>
                    <td>${pl.nom}</td>
                    <td>${pl.prenom}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../layouts/footer.jsp" />