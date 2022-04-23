<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="indexStyle.css">
</head>
<body>
    <div class="container">
        <h1>Send an Omikuji</h1>
        <div class="form-box">
            <form action="/processForm" method="post">
                <label for="number">Pick any number from 5 to 25</label>
                <input type="number" min="5" name="number">
                <label for="city">Enter the name of any city</label>
                <input type="text" name="city">
                <label for="name">Enter the name of any real person</label>
                <input type="text" name="name">
                <label for="hobby">Enter professional endeavor or hobby:</label>
                <input type="text" name="hobby">
                <label for="livingThing">Enter any type of living thing</label>
                <input type="text" name="livingThing">
                <label for="compliment">Say something nice to someone:</label>
                <textarea name="compliment" class="compliment" cols="30" rows="10"></textarea>
                <p>Send and show a friend</p>
                <input type="submit" value="Send" class="button">
            </form>
        </div>
    </div>
</body>
</html>