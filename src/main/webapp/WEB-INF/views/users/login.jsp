<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layouts/header.jsp"/>
<div class="wrapper">
    <div class="logo">
    </div>
    <div class="text-center mt-4 name">
        Lucky Dice
    </div>
    <form class="p-3 mt-3" action="${pageContext.request.contextPath}/Login" method="post">
        <div class="form-field d-flex align-items-center">
            <span class="far fa-user"></span>
            <input type="text" name="login" id="login" placeholder="Login">
        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-key"></span>
            <input type="password" name="password" id="pwd" placeholder="Password">
        </div>
        <button class="btn mt-3" onclick="validate()">Login</button>
    </form>
    <div class="text-center fs-6">
        <a href="#">Forget password?</a> or <a href="${pageContext.request.contextPath}/Signing">Sign up</a>
    </div>

    <div class="alert-danger p-3 text-center">
        <p class="text-danger">${requestScope.error}</p>
    </div>
</div>

<script src="${pageContext.request.contextPath}/style/js/login.js">
</script>
<jsp:include page="../layouts/footer.jsp"/>