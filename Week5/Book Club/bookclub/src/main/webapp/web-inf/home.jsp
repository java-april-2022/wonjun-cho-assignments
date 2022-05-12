<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1 style="color:purple">Book Club</h1>
    <p>A place for friends to share thoughts on books.</p>

    <div class="container">
      <div class="row align-items-start">

        <div class="col">
          <h1>Register</h1>

          <form:form action="/register" method="post" modelAttribute="newUser">

            <div class="row mb-3">
              <form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
              <div class="col-sm-10">
                <form:errors path="name"/>
                <form:input type="text" class="form-control" path="name"/>
              </div>
            </div>

            <div class="row mb-3">
              <form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
              <div class="col-sm-10">
                <form:errors path="email"/>
                <form:input type="email" class="form-control" path="email"/>
              </div>
            </div>

            <div class="row mb-3">
              <form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
              <div class="col-sm-10">
                <form:errors path="password"/>
                <form:input type="password" class="form-control" path="password"/>
              </div>
            </div>

            <div class="row mb-3">
              <form:label path="confirm" class="col-sm-2 col-form-label">Confirm Password</form:label>
              <div class="col-sm-10">
                <form:errors path="confirm"/>
                <form:input type="password" class="form-control" path="confirm"/>
              </div>
            </div>

            <form:button type="submit">Submit</form:button>

          </form:form>
        </div>

        <div class="col">
          <h1>Log in</h1>

          <form:form action="/login" method="post" modelAttribute="loginUser">

            <div class="row mb-3">
              <form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
              <div class="col-sm-10">
                <form:errors path="email"/>
                <form:input type="email" class="form-control" path="email"/>
              </div>
            </div>

            <div class="row mb-3">
              <form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
              <div class="col-sm-10">
                <form:errors path="password"/>
                <form:input type="password" class="form-control" path="password"/>
              </div>
            </div>

            <form:button type="submit">Submit</form:button>

          </form:form>
        </div>

      </div>
    </div>

</body>
</html>