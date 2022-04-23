<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resultStyle.css">
</head>
<body>
    <div class="container">
        <h1>Here's Your Omikuji!</h1>
        <div class="box">
            <p><c:out value="${result}"></c:out></p>
        </div>
        <div class="secondBox">
            <a href="/omikuji">Go Back</a>
        </div>
    </div>
</body>
</html>