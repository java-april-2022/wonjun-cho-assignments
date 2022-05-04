<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

    <h1>New Ninja</h1>

    <form:form action="/ninjas/new/create" method="post" modelAttribute="ninja">

        <div>
            <form:label path="dojo">Dojo: </form:label>
            <form:errors path="dojo"/>
            <form:select path="dojo">

                <c:forEach var="dojoList" items="${dojos}">
                    <form:option value="${dojoList}">
                        <c:out value="${dojoList.name}"/>
                    </form:option>
                </c:forEach>

            </form:select>
        </div>

        <div>
            <form:label path="firstName">First Name: </form:label>
            <form:errors path="firstName"/>
            <form:input type="text" path="firstName"/>
        </div>

        <div>
            <form:label path="lastName">Last Name: </form:label>
            <form:errors path="lastName"/>
            <form:input type="text" path="lastName"/>
        </div>

        <div>
            <form:label path="age">Age: </form:label>
            <form:errors path="age"/>
            <form:input type="number" path="age" min="15"/>
        </div>

        <div style="margin-left: 180px">
            <form:button type="submit">Create</form:button>
        </div>

    </form:form>

</body>
</html>