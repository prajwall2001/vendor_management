<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        background-image:url('https://images.freecreatives.com/wp-content/uploads/2016/04/Beautiful-Plain-Website-Background.jpg');
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
    .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
        width: 40%;
        height:400px;
    }
</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <img src="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg" width="40" height="40" class="d-inline-block align-top" alt="Logo">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
            </ul>  
        </div>
    </div>
</nav>
</head>
<body>
<form action="views" method="get">
</form>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Location</th>
            <th scope="col">GST No</th>
            <th scope="col">Company Start Date</th>
            <th scope="col">Owner Name</th>
            <th scope="col">Service Type</th>
            <th scope="col">Contact No</th>
            <th scope="col">Alternative No</th>
            <th scope="col">Email</th>
            <th scope="col">Website</th>
            <th scope="col">Status</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${entity.id}</td>
            <td>${entity.name}</td>
            <td>${entity.location}</td>
            <td>${entity.gstNo}</td>
            <td>${entity.companyStartDate}</td>
            <td>${entity.ownerName}</td>
            <td>${entity.serviceType}</td>
            <td>${entity.contactNo}</td>
            <td>${entity.alternativeNo}</td>
            <td>${entity.email}</td>
            <td>${entity.website}</td>
            <td>${entity.status}</td>
        </tr>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
<footer>
    <span>&copy; 2024 Vendor Management Project</span><br>
</footer>
</html>
