<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>

<style>
body {
	padding-top: 70px;
}

.input-container {
	display: inline-block;
	margin-right: 20px; /* Adjust margin as needed */
}

.input-style {
	border: 1px solid #ccc;
	padding: 5px;
	border-radius: 5px; /* Optional: adds rounded corners */
	box-sizing: border-box;
	/* Optional: includes padding and border in element's total width and height */
}

.label-style {
	font-weight: bold;
}
</style>
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="#">Product Management</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<!-- Add any additional navbar links here -->
			</ul>
		</div>
	</nav>

	<h2>Admin page</h2>
	<div class="container mt-5">
		<button class="btn btn-primary mb-3" id="viewProductBtn">View
			Product</button>
		<button class="btn btn-primary mb-3" id="viewVendorBtn">View
			Vendor</button>
	</div>
	<!-- view vendor detailes table--------------------------------------  -->
	<!------------------------------- User details table-------------------------------- -->
	<div class="table-responsive" id="userDetailsTableContainer"
		style="display: none;">
		<div class="row mb-3">
			<div class="col">
				<h3 id="vendorTable">Vendor Details</h3>
			</div>
			<div class="col-3">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search..."
						aria-label="Search" id="searchInput">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="button"
							id="searchButton">Search</button>
					</div>
				</div>
			</div>
		</div>
		<table id="userDetailsTable"
			class="table table-bordered table-hover table-fixed">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Image</th>
					<th>Name</th>
					<th>Email</th>
					<th>Contact Number</th>
					<th>AltContact Number</th>
					<th>vendorName</th>
					<th>GSTNumber</th>
					<th>StartDate</th>
					<th>WebSite</th>
					<th>Address</th>
					<th>PinCode</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<!-- Table body content goes here -->
			</tbody>
		</table>
	</div>
	<!------------------------------view product table  ------------------------------------------->
	<div class="table-responsive" id="productDetailsTableContainer"
		style="display: none;">
		<div class="row mb-3">
			<div class="col">
				<h3 id="productTable">All Product Details</h3>
			</div>
			<div class="col-3">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search..."
						aria-label="Search" id="searchInput">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="button"
							id="searchButton">Search</button>
					</div>
				</div>
			</div>
		</div>
		<table id="productDetailsTable"
			class="table table-bordered table-hover table-fixed">
			<!-- Table headers -->
			<thead class="thead-dark top-fixed">
				<tr>
					<th>SlNo</th>
					<th>ProductID</th>
					<th>VendorName</th>
					<th><select id="categoryFilter">
							<option value="">All Categories</option>
							<option value="grocery">Grocery</option>
							<option value="electronics">Electronics</option>
							<option value="cloths">Cloth's</option>
							<option value="home_furnitures">Home and Furniture's</option>
							<option value="cosmetics">Cosmetics</option>
							<option value="appliances">Appliances</option>
					</select></th>
					<th>ProductName</th>
					<th>ProductPrice</th>
					<th>DeliveryCharge</th>
					<th>DescriptionAboutProduct</th>
					<th>Available</th>
					<!-- <th>orderStatus</th> -->
					<th>Action</th>
					<th>vendor</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>

	<!-- --------------------------------view vendor Modal----------------------- -->
	<div class="modal fade custom-width-modal " id="editUserModal"
		tabindex="-1" role="dialog" aria-labelledby="editUserModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center" id="editUserModalLabel">
						vendor Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h3 class="text-center">Personal Details</h3>
					<div class="row">
						<!-- Personal Details -->
						<div class="col-md-8">
							<p>
								<strong>Vendor ID:</strong> <span id="vendorId"></span>
							</p>
							<p>
								<strong><i class="fa-solid fa-user"></i>Owner Name:</strong> <span
									id="ownerName"></span>
							</p>
							<p>
								<strong><i class="fa-solid fa-envelope"></i>Email:</strong> <span
									id="email"></span>
							</p>
							<p>
								<strong><i class="fa-solid fa-phone"></i>Contact
									Number:</strong> <span id="contactNumber"></span>
							</p>
							<p>
								<strong><i class="fa-solid fa-phone"></i>Alternate
									Contact Number:</strong> <span id="altContactNumber"></span>
							</p>
						</div>

						<!-- User Photo -->
						<div class="col-md-4 text-center">
							<div class="round-image mb-3"
								style="height: 100px; width: 100px; overflow: hidden; border-radius: 50%;">
								<img id="userPhoto"
									src="http://localhost:8081/VendorManagement/admin/display?email="
									alt="User Photo" style="width: 100%; height: auto;">
							</div>
						</div>
					</div>
					<h3 class="text-center">Business Details</h3>
					<div class="row justify-content-center">
						<div class="col-md-6">
							<p>
								<strong><i class="fa-solid fa-user"></i>Vendor Name:</strong> <span
									id="vendorName"></span>
							</p>
							<p>
								<strong><i class="fa-solid fa-pencil"></i>GST Number:</strong> <span
									id="GSTNumber"></span>
							</p>
							<p>
								<strong><i class="fa-solid fa-date"></i>Start Date:</strong> <span
									id="startDate"></span>
							</p>
						</div>
						<div class="col-md-6">
							<p>
								<strong><i class="fa-solid fa-globe"></i>WebSite:</strong> <span
									id="website"></span>
							</p>
							<p>
								<strong><i class="fa-regular fa-building"></i>Address:</strong>
								<span id="address"></span>
							</p>
							<p>
								<strong><i class="fa-regular fa-building"></i>Pin Code:</strong>
								<span id="pincode"></span>
							</p>
						</div>
					</div>

					<p>
						<strong>vendor status:</strong> <input type="hidden" id="vendorId">
						<input type="hidden" id="vendorEmail"> <select
							class="form-control" id="VendorStatus" name="status" required>
							<option value="">Select Availability</option>
							<option value="pending">Pending</option>
							<option value="approved">Approved</option>
						</select>
					</p>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button  onclick="saveVendorStatus()" type="button" class="btn btn-primary">Save
						Changes</button>
				</div>
			</div>
		</div>
	</div>
	<!-----------------------------------------  -->
	<!-- Vendor Success Modal -->
	<div class="modal fade" id="vendorSuccessModal" tabindex="-1"
		role="dialog" aria-labelledby="vendorSuccessModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content bg-success text-white">
				<div class="modal-body">Vendor status updated successfully.</div>
			</div>
		</div>
	</div>

	<!-- Vendor Error Modal -->
	<div class="modal fade" id="vendorErrorModal" tabindex="-1"
		role="dialog" aria-labelledby="vendorErrorModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content bg-danger text-white">
				<div class="modal-body">An error occurred while updating
					vendor status.</div>
			</div>
		</div>
	</div>
	<!---------------------------------------Order Product Modal------------------------------------------------>
	<div class="modal fade" id="OrderProductModal" tabindex="-1"
		role="dialog" aria-labelledby="OrderProductModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="OrderProductModalLabel">
						<i class="fas fa-info-circle"></i> Product Details
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6">
							<strong><i class="fas fa-user"></i> Vendor Name:</strong><span
								id="PvendorName"></span>
						</div>
						<div class="col-md-6">
							<strong><i class="fas fa-cube"></i> Product ID:</strong><span
								id="ProductId"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<strong><i class="fas fa-list"></i> Category:</strong> <span
								id="category"></span>
						</div>
						<div class="col-md-6">
							<strong><i class="fas fa-shopping-bag"></i> Product
								Name:</strong> <span id="productName"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<strong><i class="fas fa-dollar-sign"></i> Product
								Price:</strong> <span id="productPrice"></span>
						</div>
						<div class="col-md-6">
							<strong><i class="fas fa-truck"></i> Delivery Charge:</strong> <span
								id="deliveryCharge"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<strong><i class="fas fa-check-circle"></i> Available:</strong> <span
								id="available"></span>
						</div>
						<div class="col-md-6">
							<strong><i class="fas fa-info-circle"></i> Description
								About Product:</strong> <span id="descriptionAboutProduct"></span>
						</div>
					</div>
					<fieldset>
						<legend>
							<i class="fas fa-tasks"></i> Fill Order Details
						</legend>
						<form id="OrderProductForm">
							<input type="hidden" id="orderProductId" name="productId">
							<input type="hidden" id="ordervendorId" name="vendorId">
							<div id="orderFields">
								<label for="orderStatus"><i class="fas fa-check-circle"></i>
									Order Status:</label> <input type="text" id="orderStatus"
									class="form-control" name="orderStatus" value="Ordered"
									readonly="readonly"> <label for="quantity"><i
									class="fas fa-sort-numeric-up"></i> Quantity:</label> <input
									type="text" id="quantity" name="orderQuantity"
									class="form-control"> <label for="deliveryDate"><i
									class="far fa-calendar-alt"></i> Delivery Date:</label> <input
									type="date" id="deliveryDate" name="deliveryDate"
									class="form-control"> <label for="deliveryAddress"><i
									class="fas fa-map-marker-alt"></i> Delivery Address:</label> <input
									type="text" id="deliveryAddress" name="deliveryAddress"
									class="form-control"> <label for="message"><i
									class="far fa-comment"></i> Message:</label> <input type="text"
									id="message" class="form-control" name="message">
							</div>
						</form>
					</fieldset>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="submitOrderBtn" type="button" class="btn btn-primary">
						<i class="fas fa-save"></i> Submit
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- ------------------------------------------------------------------- -->
	<!-- Order Success Modal -->
	<div class="modal fade" id="orderSuccessModal" tabindex="-1"
		role="dialog" aria-labelledby="orderSuccessModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content bg-success text-white">
				<div class="modal-body">Order placed successfully.</div>
			</div>
		</div>
	</div>

	<!-- Order Error Modal -->
	<div class="modal fade" id="orderErrorModal" tabindex="-1"
		role="dialog" aria-labelledby="orderErrorModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content bg-danger text-white">
				<div class="modal-body">An error occurred while placing the
					order.</div>
			</div>
		</div>
	</div>
	<!-------------------------------- this API is getting all vendor List and save vendor status------------------>
	<script>
		// Define a function to fetch vendors data
		function getVendors() {
			$("#productDetailsTableContainer").hide();
			$("#userDetailsTableContainer").toggle();
			if ($("#userDetailsTableContainer").is(":visible")) {
				$
						.ajax({
							url : "viewVendorDetails",
							type : "GET",
							dataType : "json",
							success : function(data) {
								console.log(data);
								$("#userDetailsTable tbody").empty();
								$
										.each(
												data,
												function(index, item) {
													var row = "<tr>" + "<td>"
															+ item.id
															+ "</td>"
															+ "<td><img src='display?imagePath="
															+ item.imagePath
															+ "' alt='Profile Picture' width='50' height='50'></td>"
															+ "<td>"
															+ item.ownerName
															+ "</td>"
															+ "<td class='edit-email'>"
															+ item.email
															+ "</td>"
															+ "<td>"
															+ item.contactNo
															+ "</td>"
															+ "<td>"
															+ item.alternativeNo
															+ "</td>"
															+ "<td>"
															+ item.vendorName
															+ "</td>"
															+ "<td>"
															+ item.gstNo
															+ "</td>"
															+ "<td>"
															+ item.companyStartDate
															+ "</td>"
															+ "<td>"
															+ item.website
															+ "</td>"
															+ "<td>"
															+ item.address
															+ "</td>"
															+ "<td>"
															+ item.pincode
															+ "</td>"
															+ "<td>"
															+ item.status
															+ "</td>"
															+ "<td><button class='btn btn-primary btn-sm' onclick='editVendor("
															+ JSON
																	.stringify(item)
															+ ")'><i class='fas fa-eye'></i>view</button></td>"
															+ "</tr>";
													$("#userDetailsTable tbody")
															.append(row);
												});
							},
							error : function(xhr, status, error) {
								alert("Failed to fetch user data from server.");
								console.error(error);
							}
						});
			}
		}

		// Click event handler for #viewButton
		$("#viewVendorBtn").click(function() {
			getVendors();
		});

		function editVendor(vendor) {
			console.log(vendor);
			$('#editUserModal').modal('show');
			$('#vendorId').val(vendor.id);
			$('#vendorId').text(vendor.id);
			$('#ownerName').text(vendor.ownerName);
			$('#vendorEmail').text(vendor.email);
			$('#editUserModal #email').text(vendor.email);
			var userEmail = vendor.email;
			$('#userPhoto').attr(
					'src',
					'http://localhost:8081/VendorManagement/admin/display?imagePath='
							+ vendor.imagePath);
			$('#contactNo').text(vendor.contactNo);
			$('#altContactNo').text(vendor.alternativeNo);
			$('#vendorName').text(vendor.vendorName);
			$('#GSTNo').text(vendor.gstNo);
			$('#startDate').text(vendor.startDate);
			$('#website').text(vendor.website);
			$('#address').text(vendor.address);
			$('#pincode').text(vendor.pincode);
			$('#VendorStatus').val(vendor.status);
		}
	</script>
	<script>

	function saveVendorStatus() {
	    var vendorId = $('#vendorId').val();
	    var vendorEmail = $('#vendorEmail').val();
	    var status = $('#VendorStatus').val();
	    console.log('saveVendorStatus');

	    $.ajax({
	        type: 'POST',
	        url: 'updateVendorStatus', // Add comma here
	        data: {
	            id: vendorId,
	            vendorEmail: vendorEmail,
	            status: status
	        },
	        success: function(response) {
	            if (response.includes("updateVendorStatusSuccessfully")) {
	                console.log('Vendor status updated successfully');
	                $('#editUserModal').modal('hide');
	                getVendors();
	                // Show success modal
	                $('#vendorSuccessModal').modal('show');
	                // Hide success modal after 3 seconds
	                setTimeout(function() {
	                    $('#vendorSuccessModal').modal('hide');
	                }, 3000);
	            } else {
	                console.log('Vendor status update failed');
	                $('#editUserModal').modal('hide');
	                // Show error modal
	                $('#vendorErrorModal').modal('show');
	                // Hide error modal after 3 seconds
	                setTimeout(function() {
	                    $('#vendorErrorModal').modal('hide');
	                }, 3000);
	            }
	        },
	        error: function(xhr, status, error) {
	            const errorMessage = "An error occurred while updating vendor status: " + error;
	            $('#vendorErrorMessage').text(errorMessage);
	            $('#editUserModal').modal('hide');
	            // Show error modal
	            $('#vendorErrorModal').modal('show');
	            // Hide error modal after 3 seconds
	            setTimeout(function() {
	                $('#vendorErrorModal').modal('hide');
	            }, 3000);
	        }
	    });
	}


 
 	</script>
 	
	<script>
	$(document).ready(function() {
	    $("#viewProductBtn").click(function() {
	        $("#userDetailsTableContainer").hide();
	        $("#productDetailsTableContainer").toggle();
	        if ($("#productDetailsTableContainer").is(":visible")) {
	            $.ajax({
	                url: "viewproduct",
	                type: "GET",
	                dataType: "json",
	                success: function(data) {
	                    $("#productDetailsTable tbody").empty();
	                    $.each(data, function(index, item) {
	                        var slno = index + 1;
	                        var row = "<tr>" +
	                            "<td>" + slno + "</td>" +
	                            "<td>" + item.id + "</td>" +
	                            "<td>" + item.vendor.vendorName + "</td>" +
	                            "<td>" + item.category + "</td>" +
	                            "<td>" + item.productName + "</td>" +
	                            "<td>" + item.productPrice + "</td>" +
	                            "<td>" + item.deliveryCharge + "</td>" +
	                            "<td>" + item.description + "</td>" +
	                            "<td>" + item.available + "</td>" +
	                            "<td><button class='btn btn-warning btn-sm' onclick='orderProduct(" + JSON.stringify(item) + ")'><i class='fas fa-shopping-cart'></i> Order</button></td>" +
	                            "<td><button class='btn btn-primary btn-sm' onclick='editVendor(" + JSON.stringify(item.vendor) + ")'><i class='fas fa-eye'></i>Vendor</button></td>" +
	                            "</tr>";
	                        $("#productDetailsTable tbody").append(row);
	                    });
	                },
	                error: function(xhr, status, error) {
	                    alert("Failed to fetch product data from server.");
	                    console.error(error);
	                }
	            });
	        }
	    });
	});

		function orderProduct(product) {
		
			$('#OrderProductModal').modal('show');
			$('#orderProductId').val(product.id);
			$('#ordervendorId').val(product.vendor.id);
			$('#ProductId').text(product.id);
			$('#PvendorName').text(product.vendor.vendorName);
			$('#category').text(product.category);
			$('#productName').text(product.productName);
			$('#productPrice').text(product.productPrice);
			$('#deliveryCharge').text(product.deliveryCharge);
			$('#descriptionAboutProduct').text(product.description);
			$(' #available').text(product.available);
		}
		
		
		

	</script>
	<script>
$(document).ready(function() {
    $("#submitOrderBtn").click(function() {
        event.preventDefault();
        var formData = $("#OrderProductForm").serialize();
        console.log("Form data:", formData);
        $.ajax({
            type: "POST",
            url: "submitOrder",
            data: formData,
            success: function(response) {
                console.log("Order placed successfully:", response);
                $('#orderSuccessModal').modal('show');
                setTimeout(function() {
                    $('#orderSuccessModal').modal('hide');
                }, 3000);
            },
            error: function(xhr, status, error) {
                console.error("Error placing order:", error);
                $('#orderErrorModal').modal('show');
                setTimeout(function() {
                    $('#orderErrorModal').modal('hide');
                }, 3000);
            }
        });
    });
});
</script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
