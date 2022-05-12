<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">

      <div class="row">
        <div class="col-sm-8"><h1>Welcome, ${currentUser.name}</h1></div>
        <div class="col-sm-4"><a href="/books/logout">logout</a></div>
      </div>

      <div class="row">
        <div class="col-sm-8">Books from shelves:</div>
        <div class="col-sm-4"><a href="/books/new">+ Add a to my shelf!</a></div>
      </div>

    </div>

    <table class="table table-striped">

        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author Name</th>
            <th>Posted By</th>
        </tr>

        <c:forEach var="book" items="${books}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.user.name}"/></td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>