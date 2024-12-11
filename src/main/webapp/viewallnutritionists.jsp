<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Nutritionists</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Custom CSS for Project Styling -->
    <link rel="stylesheet" href="style.css" /> <!-- Your custom styles -->
</head>
<body>

    <!-- Admin Navbar -->
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
                            <a class="dropdown-item" href="adduser">Add User</a>
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
        <h3 class="text-center"><u>View All Nutritionists</u></h3>
        <p>Total Nutritionists: <c:out value="${nutritionistCount}"></c:out></p>

        <!-- Nutritionists Table -->
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Expertise</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${nutritionistList}" var="nutritionist">
                    <tr>
                        <td><c:out value="${nutritionist.id}"/></td>
                        <td><c:out value="${nutritionist.name}"/></td>
                        <td><c:out value="${nutritionist.expertise}"/></td>
                        <td><c:out value="${nutritionist.email}"/></td>
                        <td><c:out value="${nutritionist.contact}"/></td>
                        <td>
                            <!-- Action buttons, for example, delete -->
                            <a href="deletenutritionist?id=${nutritionist.id}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Back to Admin Home -->
        <a href="adminhome" class="btn btn-primary btn-block mt-3">Back to Admin Home</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
