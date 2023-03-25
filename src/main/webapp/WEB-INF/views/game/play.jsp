<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layouts/navbar.jsp"/>
<div class="container m-3 w-50 m-auto">
    <div class="row justify-content-center rounded-5 border border-2 border-dark mt-4 p-4 shadow-lg">
        <div class="col-md-6 m-4">
            <div class="form-container justify-content-center text-center">
                <form action="${pageContext.request.contextPath}/play" method="post">
                    <div class="form-group">
                        <label for="desNumber">Give the des number</label>
                        <select class="form-select" aria-label="Default select example" id="desNumber" name="desNumber">
                            <option value="1" selected>Dice 1</option>
                            <option value="2">Dice 2</option>
                            <option value="3">Dice 3</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary m-3" id="sbm">Submit</button>
                    <button type="submit" class="btn btn-danger m-3"
                            onclick="window.location.href='${pageContext.request.contextPath}/reset'">Reset
                    </button>
                </form>
            </div>
        </div>
    </div>
    <c:if test="${requestScope.game.getDesNumberValue().size() > 0}">
        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <div class="alert alert-info">
                    <p>${requestScope.game.getDesNumberValue()}</p>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${requestScope.error != null}">
        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <div class="alert alert-danger">
                    <p>${requestScope.error}</p>
                </div>
            </div>
        </div>
    </c:if>
</div>
<script src="${pageContext.request.contextPath}/style/js/play.js">
</script>
<jsp:include page="../layouts/footer.jsp"/>