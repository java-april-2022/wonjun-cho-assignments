<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
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

		<h1>Expense Details</h1>
		<a href="/">Go back</a>

		<table class="table">
			<tr>
				<th>Expense Details:</th>
				<td><c:out value="${expense.name}"/></td>
			</tr>
			<tr>
				<th>Expense Description:</th>
				<td><c:out value="${expense.description}"/></td>
			</tr>
			<tr>
				<th>Vendor:</th>
				<td><c:out value="${expense.vendor}"/></td>
			</tr>
			<tr>
				<th>Amount Spent:</th>
				<td><c:out value="${expense.amount}"/></td>
			</tr>
		</table>
	</div>

</body>
</html>