<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="row">
        <div class="col-sm-8"><h1>Add a Book to Your Shelf!</h1></div>
        <div class="col-sm-4"><a href="/books">back to the shelves</a></div>
    </div>

        <div class="col">
          <form:form action="/books/edit/process" method="post" modelAttribute="editBook">
            <input type="hidden" name="_method" value="put"/>

            <div><form:errors path="title" style="color:red"/></div>
            <div><form:errors path="author" style="color:red"/></div>
            <div><form:errors path="thoughts" style="color:red"/></div>

            <div class="row mb-3">
              <form:label path="title" class="col-sm-2 col-form-label">Title</form:label>
              <div class="col-sm-10">
                <form:input type="text" class="form-control" path="title"/>
              </div>
            </div>

            <div class="row mb-3">
              <form:label path="author" class="col-sm-2 col-form-label">Author</form:label>
              <div class="col-sm-10">
                <form:input type="text" class="form-control" path="author"/>
              </div>
            </div>

            <div class="row mb-3">
              <form:label path="thoughts" class="col-sm-2 col-form-label">My thoughts</form:label>
              <div class="col-sm-10">
                <form:textarea path="thoughts" class="form-control"></form:textarea>
              </div>
            </div>
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="user"/> <%-- Both elements must be put it in as hidden to not get modified. Input is required as it will create another object --%>
            <form:button type="submit">Submit</form:button>

          </form:form>
        </div>

</body>
</html>