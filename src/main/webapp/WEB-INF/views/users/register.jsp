<jsp:include page="../layouts/header.jsp"/>
<div class="wrapper">
    <div class="logo">
    </div>
    <div class="text-center mt-4 name">
        Lucky Dice
    </div>
    <form class="p-3 mt-3" action="${pageContext.request.contextPath}/Signing" method="post">
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-user"></span>
            <input type="text" name="nom" id="nom" placeholder="Nom">
        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-user"></span>
            <input type="text" name="prenom" id="prenom" placeholder="Prenom">
        </div>
        <div class="form-field d-flex align-items-center">
            <span class="far fa-user"></span>
            <input type="text" name="login" id="login" placeholder="Login">

        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-key"></span>
            <input type="password" name="password" id="pwd" placeholder="Password">
            <div class="pwd-toggle">
                <span class="fas fa-eye"></span>
            </div>

        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-key"></span>
            <input type="password" name="confpassword" id="pwdConf" placeholder="Confirm Password">
            <div class="pwd-toggle">
                <span class="fas fa-eye"></span>
            </div>
        </div>
        <div  id="error" class="text-danger">
        </div>
        <div class="alert-danger">
            <c:if test="${requestScope.error != null}">
                <c:out value="${requestScope.error}"/>
            </c:if>
        </div>
        <button class="btn mt-3" id="btnRegister">Register</button>
    </form>
    <div class="text-center fs-6">
        <a href="#">Forget password?</a> or <a href="${pageContext.request.contextPath}/Login">Login</a>
    </div>
    <div class="alert-danger p-3 text-center">
        <p class="text-danger">${requestScope.error}</p>
    </div>
</div>
<script src="${pageContext.request.contextPath}/style/js/signIn.js">
</script>
<jsp:include page="../layouts/footer.jsp" />