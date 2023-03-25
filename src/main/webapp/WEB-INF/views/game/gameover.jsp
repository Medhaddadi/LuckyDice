<jsp:include page="../layouts/navbar.jsp"/>
<div class="container m-3 w-50 m-auto">
    <div class="row justify-content-center rounded-5 border border-2 border-dark mt-4 p-4 shadow-lg">
        <div class="col-md-6 m-4">
            <div class="form-container justify-content-center text-center">
                <h1 class="text-center">Your Score: </h1>
                <p class="m-2 text-center">${requestScope.game.getScore()}</p>
                <button type="submit" class="btn btn-primary m-3">Submit</button>
                <button type="submit" class="btn btn-danger m-3"
                        onclick="window.location.href='${pageContext.request.contextPath}/reset'">Reset
                </button>
            </div>
        </div>
    </div>
    <c:if test="${requestScope.game.getDesNumberValue().size() > 0}"   >
        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <div class="alert alert-info">
                    <p>${requestScope.game.getDesNumberValue()}</p>
                </div>
            </div>
        </div>
    </c:if>
</div>
<jsp:include page="../layouts/footer.jsp"/>