<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detail</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="row">
        <div class="col-sm-8"><h1>${book.title}</h1></div>
        <div class="col-sm-4"><a href="/books">back to the shelves</a></div>
    </div>
    <c:choose>
        <c:when test="${currentUser == book.user.id}">
            <h2>You read ${book.title} by ${book.author}.</h2>
            <h2>Here are your thoughts</h2>
        </c:when>
        <c:otherwise>
            <h2>${book.user.name} read ${book.title} by ${book.author}.</h2>
            <h2>Here are ${book.user.name} thoughts:</h2>
        </c:otherwise>
    </c:choose>

    <div class="w-75 p-3" style="border-top:5px solid black; border-bottom: 5px solid black;">
        <p>${book.thoughts}</p>
    </div>

    <c:if test="${currentUser == book.user.id}">
        <button><a href="/books/${book.id}/edit">edit</a></button>
    </c:if>
</body>
</html>