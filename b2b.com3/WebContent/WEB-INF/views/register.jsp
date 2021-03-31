<%@page import="java.awt.Window"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>

<!-- Required for AJAX call -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>b2b Medical Supplies - Register</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value="/resources/theme1//vendor/fontawesome-free/css/all.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" />"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value="/resources/theme1/css/b2bCustom.css" />"
	rel="stylesheet">
<h2 class="text-center text-white text-monospace mb-2">b2b Medical
	Supplies</h2>
</head>

<body class="bg-gradient-dark">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row justify-content-center">
					<!-- 
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          -->
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">REGISTRATION</h1>
							</div>
							<form action="register" method="post"
								enctype="multipart/form-data">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<div class="dropdown">
											<select name="tempType"
												class="btn btn-user btn-success btn-block dropdown-toggle "
												id="tempType">
												<option value="" style="display: none">Select Type</option>
												<option value="pharmacy">Pharmacy</option>
												<option value="manufacturer">Manufacturer</option>
											</select> <span id="temptype" class="text-danger font-weight-bold"></span>
											<!-- 
					  <button type="button" class="btn btn-user btn-success btn-block dropdown-toggle" data-toggle="dropdown">
					    User Type
					  </button>
					  <div class="dropdown-menu">
					    <a class="dropdown-item" href="#">Pharmacy</a>
					    <a class="dropdown-item" href="#">Manufacturer</a>
					  </div>
					  -->
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											name="tempName" id="tempName" placeholder="User Name">
										<span id="tempname" class="text-danger font-weight-bold"></span>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											name="tempPass" id="tempPass" placeholder="Password">
										<span id="temppass" class="text-danger font-weight-bold"></span>
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											id="repeatPassword" placeholder="Repeat Password"> <span
											id="repeatpassword" class="text-danger font-weight-bold"></span>
									</div>
								</div>
								<div class="form-group">
									<textarea class="form-control form-control-user"
										name="tempAddr" id="tempAddr" placeholder="Address"></textarea>
									<span id="tempaddr" class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group">
									<input type="number" class="form-control form-control-user"
										name="tempPhoneNo" id="tempPhoneNo" placeholder="Phone number"
										pattern="[0-9]{10}"> <span id="tempphoneno"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										aria-describedby="emailHelp" name="tempMailId" id="tempMailId"
										placeholder="Email Address"> <span id="tempmailid"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group">
									<input type="file" name="file"
										class="btn btn-success btn-user btn-block file" id="file">
									<span id="templicense" class="text-danger font-weight-bold"></span>
								</div>

								<input class="btn btn-warning btn-user btn-block" type="reset">
								<input onclick="return validation()"
									class="btn btn-primary btn-user btn-block" type="submit"
									value="Register">

								<!DOCTYPE html>
								<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/w3css/3/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<body>


	<div class="text-center">
	<section class="w3-container w3-center w3-content"
		style="max-width: 600px">
		<l>medibox</l>

		<p>B2B MEDICAL SUPPLY is a distribution software specially
			developed for Pharma,Manufacturers medicine distribution business. It
			covers all aspects involved in running a day to day medical wholesale
			distribution business, covering point of sales, inventory management
			and accounting online billing, up to finalization stage.</p>
	</section>


	<!-- Footer -->
	<footer class="w3-container w3-padding-64 w3-center w3-black w3-xlarge">
		<a href="#"><i class="fa fa-facebook-official"></i></a> <a href="#"><i
			class="fa fa-pinterest-p"></i></a> <a href="#"><i
			class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-flickr"></i></a>
		<a href="#"><i class="fa fa-linkedin"></i></a>
		<p class="w3-medium">
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				target="_blank">b2b.com</a>
		</p>
	</footer>

	<script>
		// Automatic Slideshow - change image every 3 seconds
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].style.display = "block";
			setTimeout(carousel, 3000);
		}
	</script>

</body>
								</html>


								<script>
									function validation() {
										var usertype = document
												.getElementById('tempType').value;
										var user = document
												.getElementById('tempName').value;
										var pass = document
												.getElementById('tempPass').value;
										var conpass = document
												.getElementById('repeatPassword').value;
										var addr = document
												.getElementById('tempAddr').value;
										var mobile = document
												.getElementById('tempPhoneNo').value;
										var email = document
												.getElementById('tempMailId').value;
										var file = document
												.getElementById('file').value;

										if (usertype == "") {
											document.getElementById('temptype').innerHTML = "please select user type";
											return false;
										} else {
											document.getElementById('temptype').innerHTML = "";
										}

										if (user == "") {
											document.getElementById('tempname').innerHTML = "user name is required";
											return false;
										} else {
											document.getElementById('tempname').innerHTML = "";
										}

										if (pass == "") {
											document.getElementById('temppass').innerHTML = "password is required";
											return false;
										} else {
											document.getElementById('temppass').innerHTML = "";
										}
										if (pass.length<=5 || pass.length> = 15) {
											document.getElementById('temppass').innerHTML = "password must be between 5 and 15 characters";
											return false;
										} else {
											document.getElementById('temppass').innerHTML = "";
										}

										if (pass != conpass) {
											document.getElementById('tempPass').value = "";
											document
													.getElementById('repeatPassword').value = "";
											document.getElementById('temppass').innerHTML = "password not matching";
											return false;
										} else {
											document.getElementById('temppass').innerHTML = "";
										}

										if (conpass == "") {
											document
													.getElementById('repeatpassword').innerHTML = "this field is required";
											return false;
										} else {
											document
													.getElementById('repeatpassword').innerHTML = "";
										}

										if (addr == "") {
											document.getElementById('tempaddr').innerHTML = "address is required";
											return false;
										} else {
											document.getElementById('tempaddr').innerHTML = "";
										}

										if (mobile == "") {
											document
													.getElementById('tempphoneno').innerHTML = "phone no is required";
											return false;
										} else {
											document
													.getElementById('tempphoneno').innerHTML = "";
										}
										if (isNaN(mobile)) {
											document
													.getElementById('tempphoneno').innerHTML = "phone no must be digits only";
											return false;
										} else {
											document
													.getElementById('tempphoneno').innerHTML = "";
										}

										if (mobile.length != 10) {
											document
													.getElementById('tempphoneno').innerHTML = "phone no must be 10 digits only";
											return false;
										} else {
											document
													.getElementById('tempphoneno').innerHTML = "";
										}

										if (email == "") {
											document
													.getElementById('tempmailid').innerHTML = "email id is required";
											return false;
										} else {
											document
													.getElementById('tempmailid').innerHTML = "";
										}

										if (file == "") {
											document
													.getElementById('templicense').innerHTML = "please attach file";
											document.getElementById('file')
													.focus();
											return false;
										} else {
											document
													.getElementById('templicense').innerHTML = "";
										}

									}
								</script>



								<script>
									function myFunction() {
										alert("Your application has been submitted for approval");
									}
								</script>
								<!--
                 <a href="login.html" class="btn btn-primary btn-user btn-block">
                  Register Account
                </a>
                 -->
								<hr>
							</form>
							<hr>
							<!-- 
              <div class="text-center">
                <a class="small" href="forgot-password.html">Forgot Password?</a>
              </div>
               -->
							<div class="text-center">
								<a class="small" href="login">Already have an account? Login</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value="/resources/theme1/vendor/jquery/jquery.min.js" />"></script>
	<script
		src="<c:url value="/resources/theme1//vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value="/resources/theme1/vendor/jquery-easing/jquery.easing.min.js" />"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value="/resources/theme1/js/sb-admin-2.min.js" />"></script>
</body>

<!-- Required for AJAX call -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#tempName").change(function() {
			$.ajax({
				url : 'check_avail',
				data : {
					tempName : $("#tempName").val()
				},
				success : function(data) {
					$("#tempname").html(data);
				}
			});

		});
	});
</script>

</html>
