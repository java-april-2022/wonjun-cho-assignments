<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Save Travels</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

    		<h1>Save Travels</h1>

    		<table class="table">
    			<tr>
    				<th>Expense</th>
    				<th>Vendor</th>
    				<th>Amount</th>
    			</tr>

    			<c:forEach var="expense" items="${expenses}">

    				<tr>
    					<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
    					<td><c:out value="${expense.vendor}"/></td>
    					<td>$<c:out value="${expense.amount}"/></td>
    					<td><a href="/edit/<c:out value="${expense.id}"/>">edit</a>
    					<form action="/expenses/${expense.id}" method="post">
    					    <input type="hidden" name="_method" value="delete">
    					    <input type="submit" value="Delete" class="btn-danger">
    					</form>
    					</td>
    				</tr>

    			</c:forEach>

    		</table>

    		<h2>Add an Expense:</h2>

    		<form:form action="/expenses" method="post" modelAttribute="expense">

    			<div class="form-group">
    				<form:label path="name">Name of Product(s):</form:label>
    				<form:errors path="name" class="error"/>
    				<form:input path="name" type="text" class="form-control"/>
    			</div>

    			<div class="form-group">
    				<form:label path="description">Description:</form:label>
    				<form:errors path="description" class="error"/>
    				<form:input path="description" type="text" class="form-control"/>
    			</div>

    			<div class="form-group">
    				<form:label path="vendor">Vendor:</form:label>
    				<form:errors path="vendor" class="error"/>
    				<form:input path="vendor" type="text" class="form-control"/>
    			</div>

    			<div class="form-group">
    				<form:label path="amount">Amount:</form:label>
    				<form:errors path="amount" class="error"/>
    				<form:input path="amount" type="number" step="0.01" class="form-control"/>
    			</div>

    			<input type="submit" value="Add Expense" class="btn-primary"/>

    		</form:form>

    	</div>

</body>
</html>