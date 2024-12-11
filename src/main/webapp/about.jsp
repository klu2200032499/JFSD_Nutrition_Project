<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us - Diet & Nutrition Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <!-- Header Section -->
      <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="/">BalanceBite</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            		<a class="nav-link" href="adminlogin">ADMIN Login </a>
                        </li>
                        <li class="nav-item">
                            		<a class="nav-link" href="userlogin">User Login</a>
                        </li>
                        <li class="nav-item">
                            		<a class="nav-link" href="nutritionistlogin">Nutritionist Login</a>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Get Started
                                </a>
                                
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">	
                                    <h6 class="dropdown-header">Register</h6>
                                    <a class="dropdown-item" href="userreg">Register as User</a>
                                    <a class="dropdown-item" href="addnutritionist">Register as Nutritionist</a>
                                </div>
                            </div>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <!-- Main Content Section -->
    <main class="container mt-5">
        <h2 class="text-center mb-4">About Diet & Nutrition Management</h2>
        <p class="lead text-center">
            Diet & Nutrition Management is a platform dedicated to helping individuals achieve their health and wellness goals through personalized diet plans, expert advice from certified nutritionists, and detailed tracking of nutrition intake.
        </p>

        <div class="row">
            <div class="col-md-6">
                <h4>Our Mission</h4>
                <p>
                    Our mission is to empower individuals to take control of their health by providing them with the necessary tools, knowledge, and expert support. Whether you're looking to maintain a healthy lifestyle, lose weight, or manage a health condition, our platform offers tailored solutions to meet your needs.
                </p>
            </div>

            <div class="col-md-6">
                <h4>Why Choose Us?</h4>
                <ul>
                    <li>Personalized diet plans based on individual health and lifestyle.</li>
                    <li>Expert guidance from certified nutritionists to help you meet your wellness goals.</li>
                    <li>Track your nutrition and health progress with detailed reports and analysis.</li>
                    <li>Access to a community of like-minded individuals striving for better health.</li>
                </ul>
            </div>
        </div>

        <div class="text-center mt-5">
            <a href="/" class="btn btn-primary">Back to Home</a>
        </div>
    </main>

    <!-- Footer Section -->
    <footer class="bg-light py-4 mt-5">
        <div class="container text-center">
            <p>&copy; 2024 Diet & Nutrition Management. All Rights Reserved.</p>
            <ul class="list-unstyled">
                <li><a href="about">About Us</a></li>
                <li><a href="https://www.linkedin.com/in/karthikeya-pavan-gopisetty-280518255/">Contact</a></li>
                <li><a href="/privacy">Privacy Policy</a></li>
            </ul>
        </div>
    </footer>

    <!-- Bootstrap JS, Popper.js, and jQuery (required for some Bootstrap components) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
