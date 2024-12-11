<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User Status</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Update User Status</h2>
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userlist}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.status}</td>
                        <td>
                            <a href="updatestatus?id=${user.id}&status=active" class="btn btn-success">Activate</a>
                            <a href="updatestatus?id=${user.id}&status=inactive" class="btn btn-warning">Deactivate</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="adminhome" class="btn btn-primary btn-block mt-3">Back to Admin Home</a>
    </div>
</body>
</html>
