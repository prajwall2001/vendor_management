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
    color: #fff;
    background-image: url('https://wallpaperaccess.com/full/744085.png');
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
input[type="number"],
input[type="password"] {
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

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(-20px); }
    to { opacity: 1; transform: translateY(0); }
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
 
    <div class="container">
        <h3 style="text-align: center;">Admin Login Form</h3>
        <form action="adminPortal" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label> 
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" onchange="adminLoginMail()" /> 
                <span id="emailErrMsg" style="color: red;"></span>
            </div>
            
            <div class="mb-3">
                <label for="password" class="form-label">Password</label> 
                <input type="password" class="form-control" id="password" name="password" placeholder="Please enter your password" minlength="8" onchange="validatePassword" /> 
                <span id="passwordErrMsg" style="color: red;"></span>
            </div>
            <div class="input-box">
                <button type="submit" class="btn btn-success" id="loginBtn" >Log in</button>
            </div>
        </form>
    </div>
<!-- 	<script>
	//loginUsingEmail
	function adminLoginMail() {
		const email = document.getElementById("email").value;
		const genaratedOtpBtn = document.getElementById("otpButton");
		if (email == "" || email == null) {
			document.getElementById("emailErrMsg").innerHTML = "*Email can't be blank";
			console.log("Email can't be blank");
			genaratedOtpBtn.setAttribute("disabled", "");
		} else if (!email
				.match(/^([a-zA-Z0-9\.]+@+[a-zA-Z]+(\.)+[a-zA-Z]{2,})$/)) {
			document.getElementById("emailErrMsg").innerHTML = "*Email should be in format";
			genaratedOtpBtn.setAttribute("disabled", "");
			console.log("Email should be character");
		} else if (email != "" || email != null) {

			const xhttp = new XMLHttpRequest();
			xhttp.open("GET",
					"http://localhost:8080/vmanagement/adminLoginMailAjax/"
							+ email);
			xhttp.send();

			xhttp.onload = function() {
				const response = document.getElementById("emailErrMsg").innerHTML = this.responseText;
				if (response == "") {
					genaratedOtpBtn.removeAttribute("disabled");
				} else {
					genaratedOtpBtn.setAttribute("disabled", "");
				}
			}
		}
	}
	 
	//password
	function validatePassword() {
	    var password = document.getElementById("password").value;
	    var passwordErrMsg = document.getElementById("passwordErrMsg");
	    var loginBtn = document.getElementById("loginBtn");

	    if (password.length < 8) {
	        passwordErrMsg.innerHTML = "Password must be at least 8 characters long";
	        loginBtn.disabled = true;
	    } else {
	        var xhttp = new XMLHttpRequest();
	        xhttp.onreadystatechange = function() {
	            if (this.readyState == 4 && this.status == 200) {
	                var response = this.responseText;
	                if (response === "valid") {
	                    passwordErrMsg.innerHTML = "";
	                    loginBtn.disabled = false;
	                } else {
	                    passwordErrMsg.innerHTML = "Invalid password";
	                    loginBtn.disabled = true;
	                }
	            }
	        };
	        xhttp.open("GET", "adminLoginPasswordAjax/" + password, true);
	        xhttp.send();
	    }
	} -->
<!-- </script> -->
	
</body>
<footer>
	<span>&copy; 2024 Vendor Management Project</span><br>
</footer>
</html>
