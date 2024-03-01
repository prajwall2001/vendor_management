<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	
<style>
body {
	font-family: Arial, sans-serif;
	color: #fff;
	background-image:
		url('https://images.freecreatives.com/wp-content/uploads/2016/04/Beautiful-Plain-Website-Background.jpg');
	background-color: black;
	background-size: cover;
	background-repeat: no-repeat;
}

 .container {
                width: 35%;
    border: 2px solid #ccc;
    border-radius: 10px;
    padding: 5px;
    padding-bottom: -11px;
    background-color: rgba(0, 0, 0, 0.5);
    animation: fadeIn 1s ease;
        }

label {
	font-weight: bold;
}

input[type="email"],
input[type="number"] {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	background-color: rgba(255, 255, 255, 0.1);
	color: #858585;
	transition: all 0.3s ease;
}

.btn {
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

.btn-secondary {
    background-color: #6c757d;
    color: #fff;
    border: none;
}

.btn-secondary:hover {
    background-color: #5a6268;
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
 
	<div class="container">
		<h1 style="text-align: center;color:#07ee39;">Login Form</h1>
		<form action="sendOTP" method="post">
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Enter your email" onchange="loginMail()" /> 
					<span id="emailMsg" style="color: red;"></span>
			</div>
			
			<div class="mb-3">
				<label for="otp" class="form-label">OTP</label> <input
					type="number" class="form-control" id="otp" name="otp"
					placeholder="please enter your otp" onchange="validateOTP()" /> 
					<span id="otpErrMsg" style="color: red;"></span>
			</div>
<div class="input-box">
				<button type="button" class="btn btn-primary" id="otpButton"
					onclick="genarateOtp()" disabled="disabled">Generate OTP</button>

				<button type="submit" class="btn btn-secondary" id="loginBtn"
					disabled="disabled">Log in</button>
	</div>
	</form>
	<script>
	//loginUsingEmail
	function loginMail() {
		const email = document.getElementById("email").value;
		const genaratedOtpBtn = document.getElementById("otpButton");
		if (email == "" || email == null) {
			document.getElementById("emailMsg").innerHTML = "*Email can't be blank";
			console.log("Email can't be blank");
			genaratedOtpBtn.setAttribute("disabled", "");
		} else if (!email
				.match(/^([a-zA-Z0-9\.]+@+[a-zA-Z]+(\.)+[a-zA-Z]{2,})$/)) {
			document.getElementById("emailMsg").innerHTML = "*Email should be in format";
			genaratedOtpBtn.setAttribute("disabled", "");
			console.log("Email should be character");
		} else if (email != "" || email != null) {

			const xhttp = new XMLHttpRequest();
			xhttp.open("GET",
					"http://localhost:8080/VendorManagement/loginMailAjax/"
							+ email);
			xhttp.send();

			xhttp.onload = function() {
				const response = document.getElementById("emailMsg").innerHTML = this.responseText;
				if (response == "") {
					genaratedOtpBtn.removeAttribute("disabled");
				} else {
					genaratedOtpBtn.setAttribute("disabled", "");
				}
			}
		}
	}
	
	//genarateOtp
	function genarateOtp() {
		const email = document.getElementById("email").value;

		const xhttp = new XMLHttpRequest();
		xhttp.open("GET","http://localhost:8080/VendorManagement/loginOtpEmailMsg/" + email);
		xhttp.send();

		xhttp.onload = function() {
			document.getElementById("otpErrmsg") = this.responseText;
		}

	}

	//loginOtpAjax
	function validateOTP() {
		const otp = document.getElementById("otp").value;
		const loginButton = document.getElementById("loginBtn");

		if (otp == null || otp == "") {
			console.log("Otp cannot be empty");
			document.getElementById("otpErrMsg").innerHTML = "OTP cannot Be Empty";
			loginButton.setAttribute("disabled", "");
		} else if (otp.length > 6 || otp.length < 6) {
			console.log("Otp should be format");
			document.getElementById("otpErrMsg").innerHTML = "OTP should be in format";
			loginButton.setAttribute("disabled", "");
		} else if (otp != "") {

			const xhttp = new XMLHttpRequest();

			xhttp.open("GET",
					"http://localhost:8080/VendorManagement/loginOtpAjax/"
							+ otp);
			xhttp.send();

			xhttp.onload = function() {
				const response = document.getElementById("otpErrMsg").innerHTML = this.responseText;
				if (response == "OTP matched") {
					loginButton.removeAttribute("disabled");
				} else {
					loginButton.setAttribute("disabled", "");
				}

			}
		}

	}
</script>
	
</body>
<footer>
	<span>&copy; 2024 Vendor Management Project</span><br>
</footer>
</html>
