<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor management</title> 
<link rel="icon" type="logo/jpg" href="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
     body {
        font-family: Arial, sans-serif;
        background-color: black; 
        color:white;
        background-image:url('https://wallpaperaccess.com/full/744085.png');
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
        h4{
        color:rgb(195, 195, 195);
        }
         .success-message {
          
            animation-name: slideIn;
            animation-duration: 1s; 
            animation-timing-function: ease;
        }

        @keyframes slideIn {
            from {
                transform: translateX(-100%);
                opacity: 0;
            }
            to {
                transform: translateX(0);
                opacity: 1;
            }
        }
</Style>

 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
        <img src="https://static.vecteezy.com/system/resources/previews/004/526/847/original/women-protection-rgb-color-icon-protect-girls-against-violence-female-empowerment-women-safety-gender-equality-provide-peace-and-security-isolated-illustration-simple-filled-line-drawing-vector.jpg" width="40" height="40" class="d-inline-block align-top" alt="Logo">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    
                      <li class="nav-item">
          <a class="nav-link" href="admin.jsp">Admin</a>
        </li>
       
                </ul>  
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <%= session.getAttribute("loggedInEmail") %>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="views?email=${loggedInEmail}">View</a></li>
                            <li><a class="dropdown-item" href="update.jsp">Update</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</head>
<body>
<h3 style="color:#07ee39; text-align: center; ">Vendor Management</h3>
<form action="lSuccess" method="post"> </form>
<div class="success-message">
<h3 style='color:green;'>Login Successful</h3>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
 <footer>
    <span>&copy; 2024 Vendor Management Project</span><br>
</footer>
</html>