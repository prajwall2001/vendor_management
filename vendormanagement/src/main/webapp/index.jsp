<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="icon" type="logo/jpg" href="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg">
<link rel="icon" type="logo/jpg" href="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg">

<style>
body {
        font-family: Arial, sans-serif;
        background-size: cover;
        background-repeat: no-repeat;
    }

   .login-form {
    margin: 0 auto; /* Centers the form horizontally */
    width: 620px; /* Set your desired width */
    padding: 20px;
    background-color: rgb(192, 239, 242);
    animation: fadeIn 1s ease;
    border-radius: 10px;
}

    label {
        font-weight: bold;
        color: black;
    }


@keyframes slideInLeft {
    0% {
        transform: translateX(-100%);
    }
    100% {
        transform: translateX(0);
    }
}
h1 {
    animation: 1s ease-out 0s 1 slideInLeft;
    background: black;
    padding: 10px;
}
body {
    font-family: Arial, sans-serif;
    color: white;
    background-size: cover;
    background-repeat: no-repeat;
}
footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: rgb(42, 40, 40);
    color: white;
    text-align: center;
    padding: 10px;
}
.social img {
    height: 23px;
    width: 23px;
    margin: 5px;
}
h4 {
    color: rgb(195, 195, 195);
}
.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    height: 600px;
}
.navbar .nav-link {
    color: white;
}
.navbar-nav.ml-auto {
    margin-right: 0;
}
</style>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://tse4.mm.bing.net/th?id=OIP.3bKZlDVBAtAh8DitadnD4AHaHa&pid=Api&P=0&h=180" width="40" height="40" class="d-inline-block align-top" alt="Logo">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="admin/adminLoginPage" style="color:black;"><strong>Admin</strong></a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp" style="color:black;"><strong>Login/Register</strong></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

</head>
<body>


    <form action="info" method="post">
    </form>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
<footer>
    <span>&copy; 2024 Vendor Management Project</span><br>
</footer>

</html>