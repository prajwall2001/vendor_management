<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Login</title>
<link rel="icon" type="logo/jpg" href="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
 body {
        font-family: Arial, sans-serif;
        background-size: cover;
        background-repeat: no-repeat;
    }

   .admin-form {
    margin: 0 auto; /* Centers the form horizontally */
    width: 620px; /* Set your desired width */
    padding: 20px;
    background-color: rgb(192, 239, 242);
    animation: fadeIn 1s ease;
    border-radius: 10px;
}

label {
    font-weight: bold;
}

    input[type="email"],
    input[type="password"],
    {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-sizing: border-box;
        background-color: rgba(229, 227, 227, 0.685);
        color: #000000;
        transition: all 0.3s ease;
    }

    .btn {
        margin-top: 10px;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .btn-primary {
        background-color: #007bff;
        color: #fff;
        border: none;
    }

    .btn-primary:hover {
        background-color: #0056b3;
    }

    .btn-danger {
        background-color: #dc3545;
        color: #fff;
        border: none;
        margin: auto;
    }

    .btn-danger:hover {
        background-color: #c82333;
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(-20px);
        }

        to {
            opacity: 1;
            transform: translateY(0);
        }
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
                    <a class="nav-link" href="info" style="color:black;" ><strong>Home</strong></a>
                </li>
            </ul>
           
        </div>
    </div>
</nav>
</head>
<body>
 
    <div class="admin-form">
        <h3 style="text-align: center;color:#a80f0f;">Admin Login Form</h3>
        <form action="adminLogin" method="get">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label> 
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" > 
                <span id="emailErrMsg" style="color: red;"></span>
            </div>
            
            <div class="mb-3">
                <label for="password" class="form-label">Password</label> 
                <input type="password" class="form-control" id="password" name="password" placeholder="Please enter your password" minlength="8" > 
                <span id="passwordErrMsg" style="color: red;"></span>
            </div>
            <div class="input-box">
                <button type="submit" class="btn btn-primary" id="loginBtn" >Log in</button>
            </div>
        </form>
    </div>

	
</body>
<footer>
	<span>&copy; 2024 Vendor Management Project</span><br>
</footer>
</html>
