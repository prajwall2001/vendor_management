<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
     body {
        font-family: Arial, sans-serif;
        background-color: black; 
        color:white;
        background-image: url('vm_bg.jpg');
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
</Style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Xworkz</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="registration.jsp">Registration</a>
        </li>
      </ul>  
    </div>
  </div>
</nav>
</head>
<body>
<h1 style="color:rgb(135, 0, 0); text-align: center; ">Vendor Management</h1>
<h4>A vendor management project using Java and Spring is a web application designed to streamline the process of managing vendor relationships within an organization. It includes features such as storing vendor details, tracking contracts, evaluating performance, facilitating communication, and generating reports.</h4>
<form action="info" method="post">
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
 <footer>
    <span>&copy; 2024 Vendor Management Project</span><br>
</footer>

</html>