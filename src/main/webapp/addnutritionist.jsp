<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Nutritionist</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link type="text/css" rel="stylesheet" href="style.css">
</head>

<body>

    <!-- Navbar -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="adminhome">Admin Dashboard</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>
    </header>

    <div class="container mt-5">
        <h3 class="text-center mb-4"><u>Add Nutritionist</u></h3>

        <!-- Form to Add Nutritionist -->
        <form:form modelAttribute="nutritionist" method="post" action="addnutritionist" class="form-container">

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="name" class="form-label">Name</label>
                    <form:input id="name" path="name" class="form-control" required="required"/>
                </div>
                <div class="col-md-6">
                    <label for="contact" class="form-label">Contact No</label>
                    <form:input id="contact" path="contact" class="form-control" required="required"/>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="email" class="form-label">Email</label>
                    <form:input id="email" path="email" class="form-control" required="required"/>
                </div>
                <div class="col-md-6">
                    <label for="password" class="form-label">Password</label>
                    <form:password id="password" path="password" class="form-control" required="required"/>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="expertise" class="form-label">Expertise</label>
                    <form:input id="expertise" path="expertise" class="form-control"/>
                </div>
                <div class="col-md-6">
                    <label for="bio" class="form-label">Bio</label>
                    <form:textarea id="bio" path="bio" class="form-control"/>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="dietaryRecommendations" class="form-label">Dietary Recommendations</label>
                    <form:textarea id="dietaryRecommendations" path="dietaryRecommendations" class="form-control"/>
                </div>
                <div class="col-md-6">
                    <label for="blogs" class="form-label">Blogs</label>
                    <form:textarea id="blogs" path="blogs" class="form-control"/>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-12">
                    <label for="testimonials" class="form-label">Testimonials</label>
                    <form:textarea id="testimonials" path="testimonials" class="form-control"/>
                </div>
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">Add Nutritionist</button>
                <button type="reset" class="btn btn-secondary">Clear</button>
            </div>
        </form:form>
    </div>

   <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
