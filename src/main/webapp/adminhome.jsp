<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="adminhome">Admin Dashboard</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <!-- Home Link -->
                    <li class="nav-item">
                        <a class="nav-link active" href="adminhome">Home</a>
                    </li>

                    <!-- Nutritionist Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="nutritionistDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Nutritionist
                        </a>
                        <div class="dropdown-menu" aria-labelledby="nutritionistDropdown">
                            <a class="dropdown-item" href="addnutritionist">Add Nutritionist</a>
                            <a class="dropdown-item" href="viewallnutritionists">View All Nutritionists</a>
                        </div>
                    </li>

                    <!-- User Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Users
                        </a>
                        <div class="dropdown-menu" aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="userreg">Add User</a>
                            <a class="dropdown-item" href="viewallusers">View All Users</a>
                        </div>
                    </li>

                    <!-- Logout Link -->
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="adminlogout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container mt-5">
        <h2 class="text-center">Welcome Admin</h2>
        <p class="text-center">You have successfully logged in. You can manage users and nutritionists from here.</p>

        <div class="row">
            <div class="col-md-4">
                <a href="viewallusers" class="btn btn-primary btn-block">View All Users</a>
            </div>
            <div class="col-md-4">
                <a href="addnutritionist" class="btn btn-success btn-block">Add Nutritionist</a>
            </div>
            <div class="col-md-4">
                <a href="updateuserstatus" class="btn btn-info btn-block">Update User Status</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
