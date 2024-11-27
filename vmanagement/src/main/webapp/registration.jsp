<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<link rel="icon" type="logo/jpg"
	href="https://cdn.dribbble.com/users/9125986/screenshots/16427226/vimiyans_only_logo-01.jpg">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" />

<style>
body {
	font-family: Arial, sans-serif;
	color: #fff;
	background-image: url('https://wallpaperaccess.com/full/744085.png');
	background-color: black;
	background-size: cover;
	background-repeat: no-repeat;
}

.container {
	width: 70%;
	margin: auto;
	border: 2px solid #ccc;
	border-radius: 10px;
	padding: 20px;
	background-color: rgba(0, 0, 0, 0.5);
	animation: fadeIn 1s ease;
}

label {
	font-weight: bold;
}

input[type="text"], input[type="number"], input[type="email"], input[type="tel"],
	input[type="url"], input[type="date"], input[type="option"], select {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	background-color: rgba(229, 227, 227, 0.9);
	color: #000000;
	transition: all 0.3s ease;
}

.btn {
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-success {
	background-color: #28a745;
	color: #fff;
	border: none;
}

.btn-success:hover {
	background-color: #218838;
}

.btn-danger {
	background-color: #dc3545;
	color: #fff;
	border: none;
}

.btn-danger:hover {
	background-color: #c82333;
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(-20px);
}

to {
	opacity: 1;
	transform: translateY(0);
}
}
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<img
			src="https://static.vecteezy.com/system/resources/previews/004/526/847/original/women-protection-rgb-color-icon-protect-girls-against-violence-female-empowerment-women-safety-gender-equality-provide-peace-and-security-isolated-illustration-simple-filled-line-drawing-vector.jpg"
			width="40" height="40" class="d-inline-block align-top" alt="Logo">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
</head>
<body>
	<span style='color: red;'> <c:forEach var="objectErrors"
			items="${errors}"> ${objectErrors.defaultMessage}<br>
		</c:forEach>
	</span>
	<h3 style='color: Green'>${msg}</h3>
	<h3 style='color: red'>${uniqueError}</h3>

	<form action="saveProduct" class="container" method="post" onsubmit="return validateForm();">
    <h3 style='text-align: center; color: #07ee39;'>Add Product</h3>
    <div class="row">
        <div class="col-md-6">
            <div class="design">
                <label for="category">Category</label><br>
                <input type="text" name="category" id="category" placeholder="Enter category">
            </div>
            <br>
            <div class="design">
                <label for="productName">Product Name</label><br>
                <input type="text" name="productName" id="productName" placeholder="Enter product name">
            </div>
            <br>
            <div class="design">
                <label for="productPrice">Product Price</label><br>
                <input type="number" name="productPrice" id="productPrice" placeholder="Enter product price">
            </div>
            <br>
        </div>
        <div class="col">
            <div class="design">
                <label for="deliveryCharge">Delivery Charge</label><br>
                <input type="number" name="deliveryCharge" id="deliveryCharge" placeholder="Enter delivery charge">
            </div>
            <br>
            <div class="design">
                <label for="description">Description</label><br>
                <textarea name="description" id="description" placeholder="Enter description" rows="3"></textarea>
            </div>
            <br>
            <div class="design">
                <label for="available">Available</label><br>
                <select name="available" id="available">
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                </select>
            </div>
            <br>
        </div>
    </div>
    <div class="design">
        <button type="submit" class="btn btn-success" value="send">Save Product</button>
        <button type="reset" class="btn btn-danger" value="reset">Clear</button>
    </div>
</form>

	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

</html>