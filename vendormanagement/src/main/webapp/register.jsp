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
	background-size: cover;
	background-repeat: no-repeat;
	    padding-bottom: 10px;
	
}

.registration-form {
    margin: 0 auto; /* Centers the form horizontally */
    width: 680px; /* Set your desired width */
    padding: 5px;
    background-color: rgb(192, 239, 242);
    animation: fadeIn 1s ease;
    border-radius: 10px;
}

    label {
        font-weight: bold;
        color: black;
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
                    <a class="nav-link" href="index.jsp" style="color:black;" ><strong>Home</strong></a>
                </li>
                <li>
                <a class="nav-link" href="admin/adminLoginPage" style="color:black;" ><strong>Admin</strong></a>               
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



	<div class="registration-form" id="signupForm" >

		<form action="vendorRegister" class="container" method="post"
			onsubmit="return validateForm();">
			<h3 style='text-align: center; color: #a80f0f; font-weight: bold;'>Register here</h3><br>
			<h5 style="color: blue; text-align: center;" >Personal details</h5>
			<div class="row">
				<div class="col-md-6">
					<div class="design">
						<label for="ownerName">Owner Name</label><br> <input
							type="text" name="ownerName" id="ownerName"
							placeholder="Enter owner name" value="${dto.ownerName}">
					</div>
					<br>
					<div class="design">
						<label for="contactNo">Contact Number</label><br> <input
							type="number" name="contactNo" id="contactNo"
							placeholder="Enter contact number" value="${dto.contactNo}"
							onchange="uniqueContactNo()"> <span style='color: red;'
							id="contactNoExistMsg"></span>
					</div>
					<br>
				</div>


				<div class="col">
					   <div class="design">
            <label for="email">Email</label><br>
            <input type="email" name="email" id="email" placeholder="Enter email" value="${dto.email}" onchange="uniqueEmail()" >
            <span style='color: red;' id="signupEmail"></span>
        </div>
        <br>

					<div class="design">
						<label for="alternativeNo">Alternative Contact Number</label><br>
						<input type="tel" name="alternativeNo" id="alternativeNo"
							placeholder="Enter alternative contact number"
							value="${dto.alternativeNo}" onchange="uniqueAlternativeNo()">
						<span style='color: red;' id="alternativeNoExistMsg"></span>
					</div>
					<br>
				</div>
			</div>



			<h5 style="color: blue;text-align: center; ">Business details</h5>
			<div class="row">
				<div class="col-md-6">
					<div class="design">
						<label for="ownerName">Vendor Name</label><br> <input
							type="text" name="vendorName" id="vendorName"
							placeholder="Enter vendorName name" value="${dto.vendorName}">
					</div>
					<br>

					<div class="design">
						<label for="gstNo">GST Number</label><br> <input type="text"
							name="gstNo" id="gstNo" placeholder="Enter GST number"
							value="${dto.gstNo}" onchange="uniqueGstNo()"> <span
							style='color: red;' id="gstNoExistMsg"></span>
					</div>
					<br>
					<div class="design">
						<label for="companyStartDate">Company Start Date</label><br>
						<input type="date" name="companyStartDate" id="companyStartDate"
							placeholder="Select start date"
							value="${dto.companyStartDate}">
					</div>
					<br>
				</div>
				<div class="col">
					<div class="design">
						<label for="address">Address</label><br> <input type="text"
							name="address" id="address" placeholder="Enter address "
							value="${dto.address}">
					</div>
					<br>

					<div class="design">
						<label for="website">Website</label><br> <input type="text"
							name="website" id="website" placeholder="Enter website"
							value="${dto.website}" onchange="uniqueWebsite()"> <span
							style='color: red;' id="websiteExistMsg"></span>
					</div>
					<br>

					<div class="design">
						<label for="pincode">Pincode</label><br> <input type="number"
							name="pincode" id="pincode" placeholder="Enter pincode"
							value="${dto.pincode}" onchange="uniqueWebsite()"> <span
							style='color: red;' id="pincodeExistMsg"></span>
					</div>
					<br>

				</div>
			</div>
			<div class="design">
				<button type="submit" class="btn btn-success" value="register"
					id="submitButton">Register</button>
				<button type="reset" class="btn btn-danger" value="reset">Clear</button>
			</div>

		</form>
	</div>
	</div>


	<script>
	function uniqueGstNo() {
		var submitButton = document.getElementById("submitButton");
		console.log("Running uniqueGstNo");
		const gstNo = document.getElementById("gstNo").value;
		console.log(gstNo);

		if (gstNo != null && gstNo != "" && gstNo.length < 30) {
			console.log("GstNo is valid.");
			document.getElementById("gstNoExistMsg").innerHTML = "";
			const xhttp = new XMLHttpRequest();
			xhttp.open("GET", "http://localhost:8080/vendormanagement/gstNoAjax/"
					+ gstNo);
			xhttp.send();

			xhttp.onload = function() {
				document.getElementById("gstNoExistMsg").innerHTML = this.responseText;

			}

		} else {
			console.log("Invalid gstNo");
			document.getElementById("gstNoExistMsg").innerHTML = "please enter valid gstNo.";

		}

	}

	function uniqueContactNo() {
		var submitButton = document.getElementById("submitButton");
		console.log("Running uniqueContactNo");
		const contactNo = document.getElementById("contactNo").value;
		console.log(contactNo);

		if (contactNo != null && contactNo != "" && contactNo.length == 10) {
			console.log("contactNo is valid.");
			document.getElementById("contactNoExistMsg").innerHTML = "";
			const xhttp = new XMLHttpRequest();
			xhttp.open("GET",
					"http://localhost:8080/vendormanagement/contactNoAjax/"
							+ contactNo);
			xhttp.send();

			xhttp.onload = function() {
				document.getElementById("contactNoExistMsg").innerHTML = this.responseText;

			}

		} else {
			console.log("Invalid contactNo");
			document.getElementById("contactNoExistMsg").innerHTML = "please enter valid contactNo.";
		}

	}

	function uniqueAlternativeNo() {
		var submitButton = document.getElementById("submitButton");
		console.log("Running uniqueAlternativeNo");
		const alternativeNo = document.getElementById("alternativeNo").value;
		console.log(alternativeNo);

		if (alternativeNo != null && alternativeNo != ""
				&& alternativeNo.length == 10) {
			console.log("AlternativeNo is valid.");
			document.getElementById("alternativeNoExistMsg").innerHTML = "";
			const xhttp = new XMLHttpRequest();
			xhttp.open("GET",
					"http://localhost:8080/vendormanagement/alternativeNoAjax/"
							+ alternativeNo);
			xhttp.send();

			xhttp.onload = function() {
				document.getElementById("alternativeNoExistMsg").innerHTML = this.responseText;

			}

		} else {
			console.log("Invalid alternativeNo");
			document.getElementById("alternativeNoExistMsg").innerHTML = "please enter valid alternativeNo.";
		}

	}

	function uniqueEmail() {
		var submitButton = document.getElementById("submitButton");
		console.log("Running uniqueEmail");
		const email = document.getElementById("email").value;
		console.log(email);

		if (email != null && email != "" && email.length < 30) {
			console.log("Email is valid.");
			document.getElementById("signupEmail").innerHTML = "";
			const xhttp = new XMLHttpRequest();
			xhttp.open("GET", "http://localhost:8080/vendormanagement/emailAjax/"
					+ email);
			xhttp.send();

			xhttp.onload = function() {
				document.getElementById("signupEmail").innerHTML = this.responseText;

			}

		} else {
			console.log("Invalid email");
			document.getElementById("signupEmail").innerHTML = "please enter valid email.";

		}

	}
	
	function uniqueWebsite() {
		var submitButton = document.getElementById("submitButton");
		console.log("Running uniqueWebsite");
		const website = document.getElementById("website").value;
		console.log(website);

		if (website != null && website != "" && website.length < 300) {
			console.log("Website is valid.");
			document.getElementById("websiteExistMsg").innerHTML = "";
			const xhttp = new XMLHttpRequest();
			xhttp.open("GET", "http://localhost:8080/vendormanagement/websiteAjax/" + website);
			xhttp.send();

			xhttp.onload = function() {
				document.getElementById("websiteExistMsg").innerHTML = this.responseText;

			}

		} else {
			console.log("Invalid Website");
			document.getElementById("websiteExistMsg").innerHTML = "please enter valid Website.";

		}

	}
</script>
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