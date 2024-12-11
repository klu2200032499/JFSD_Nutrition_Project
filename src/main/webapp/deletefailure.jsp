<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Failed</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center text-danger">Delete Failed</h2>
        <div class="alert alert-danger text-center">
            <strong>${message}</strong>
        </div>
        <a href="viewallusers" class="btn btn-primary btn-block">Try Again</a>
    </div>
</body>
</html>
