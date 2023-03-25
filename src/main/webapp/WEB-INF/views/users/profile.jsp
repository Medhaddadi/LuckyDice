<jsp:include page="../layouts/navbar.jsp" />
<div class="container">
  <h1 class="text-center pt-3">Player Profile</h1>
  <table class="table table-striped table-bordered shadow-sm">
    <tbody>
    <tr>
      <th>Login</th>
      <td>${requestScope.player.login}</td>
    </tr>
    <tr>
      <th>Password</th>
      <td>${requestScope.player.password}</td>
    </tr>
    <tr>
      <th>Best Score</th>
      <td>${requestScope.player.bestScore}</td>
    </tr>
    <tr>
      <th>Nom</th>
      <td>${requestScope.player.nom}</td>
    </tr>
    <tr>
      <th>Prénom</th>
      <td>${requestScope.player.prenom}</td>
    </tr>
    </tbody>
  </table>
</div>
<jsp:include page="../layouts/footer.jsp" />