<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

<style>
    body {
        font-family: Arial, sans-serif;
        color: #fff; 
        
        background-color:black;
        background-size: cover;
        background-repeat: no-repeat;  
    }

    .container {
        width: 40%;
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

    input[type="text"],
    input[type="number"],
    input[type="email"],
    input[type="tel"],
    input[type="url"],
    input[type="date"],
     input[type="option"],
   
    select {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-sizing: border-box;
        background-color: rgba(255, 255, 255, 0.1); 
        color: #858585;
        transition: all 0.3s ease; 
    }

    li {
        color: rgb(0, 0, 0);
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

    @keyframes fadeIn {
        from{
           opacity: 0;
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
    <a class="navbar-brand" href="#">Xworkz</a>
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
<span style='color:red;'>
<c:forEach var="objectErrors" items="${errors}"> ${objectErrors.defaultMessage}<br></c:forEach>
</span>
  <h1 style='color:Green'>${msg}</h1>
  <h1 style='color:red'>${uniqueError}</h1>
<form action="vendorM" class="container" method="post">
<h1 style='text-align:center'>Register here</h1>
    
    <div class="design">
        <label for="name">Name</label><br>
        <input type="text" name="name" id="name" placeholder="Enter name" value="${entity.name}">
    </div><br>
    <div class="design">
        <label for="location">Location</label><br>
        <input type="text" name="location" id="location" placeholder="Enter location" value="${entity.location}">
    </div><br>
    <div class="design">
        <label for="gstNo">GST Number</label><br>
        <input type="text" name="gstNo" id="gstNo" placeholder="Enter GST number" value="${entity.gstNo} " onchange="uniqueGstNo()">
        <span style='color:red;' id="gstNoExistMsg"></span>
    </div><br>
    <div class="design">
        <label for="companyStartDate">Company Start Date</label><br>
        <input type="date" name="companyStartDate" id="companyStartDate" placeholder="Select start date" value="${entity.companyStartDate}">
    </div><br>
    <div class="design">
        <label for="ownerName">Owner Name</label><br>
        <input type="text" name="ownerName" id="ownerName" placeholder="Enter owner name" value="${entity.ownerName}">
    </div><br>
    <div class="design">
    <label for="serviceType">Service Type</label>
    <select class="design" id="serviceType" name="serviceType">
        <option selected value=" ">Select service type</option>
        <option value="water" <c:if test="${entity.serviceType=='water'}">selected="selected"</c:if>>Water</option>
        <option value="milk" <c:if test="${entity.serviceType=='milk'}">selected="selected"</c:if>>Milk</option>
        <option value="coffee" <c:if test="${entity.serviceType=='coffee'}">selected="selected"</c:if>>Coffee</option>
        <option value="laptop" <c:if test="${entity.serviceType=='laptop'}">selected="selected"</c:if>>Laptop</option>
        <option value="internet" <c:if test="${entity.serviceType=='internet'}">selected="selected"</c:if>>Internet</option>
        <option value="food" <c:if test="${entity.serviceType=='food'}">selected="selected"</c:if>>Food</option>
    </select>
</div><br>

    <div class="design">
        <label for="contactNo">Contact Number</label><br>
        <input type="number" name="contactNo" id="contactNo" placeholder="Enter contact number" value="${entity.contactNo}" onchange="uniqueContactNo()">
                 <span style='color:red;' id="contactNoExistMsg"></span>
         
    </div><br>
    <div class="design">
        <label for="alternativeNo">Alternative Contact Number</label><br>
        <input type="tel" name="alternativeNo" id="alternativeNo" placeholder="Enter alternative contact number" value="${entity.alternativeNo}" onchange="uniqueAlternativeNo()">
        <span style='color:red;' id="alternativeNoExistMsg"></span>
    
    </div><br>
    <div class="design">
        <label for="email">Email</label><br>
        <input type="email" name="email" id="email" placeholder="Enter email" value="${entity.email}" onchange="uniqueEmail()">
                <span style='color:red;' id="emailExistMsg"></span>   
    </div><br>
   
    <div class="design">
        <label for="website">Website</label><br>
        <input type="url" name="website" id="website" placeholder="Enter website" value="${entity.website}" onchange="uniqueWebsite()">
                        <span style='color:red;' id="websiteExistMsg"></span>       
    </div><br>
    <div class="design">
        <button type="submit" class="btn btn-success" value="send" id="submitButton">Send</button>
          <button type="reset" class="btn  btn-danger" value="reset">Clear</button>
    </div>
</form>

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
			xhttp.open("GET", "http://localhost:8080/vmanagement/gstNoAjax/"
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
					"http://localhost:8080/vmanagement/contactNoAjax/"
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
					"http://localhost:8080/vmanagement/alternativeNoAjax/"
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
			document.getElementById("emailExistMsg").innerHTML = "";
			const xhttp = new XMLHttpRequest();
			xhttp.open("GET", "http://localhost:8080/vmanagement/emailAjax/"
					+ email);
			xhttp.send();

			xhttp.onload = function() {
				document.getElementById("emailExistMsg").innerHTML = this.responseText;

			}

		} else {
			console.log("Invalid email");
			document.getElementById("emailExistMsg").innerHTML = "please enter valid email.";

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
			xhttp.open("GET", "http://localhost:8080/vmanagement/websiteAjax/" + website);
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
</body>

</html>