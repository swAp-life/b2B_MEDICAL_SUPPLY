<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<title>Login page</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value="resources/theme1//vendor/fontawesome-free/css/all.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" />"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value="resources/theme1/css/b2bCustom.css" />"
	rel="stylesheet">
<h2 class="text-center text-monospace text-white mb-2">b2b Medical
	Supplies</h2>
</head>

<body class="bg-gradient-dark">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row justify-content-center">
							<!-- 
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
               -->
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Welcome</h1>
									</div>
									<!-- FORM START -->
									<form action="login" onsubmit="return validation()"
										method="post">
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												name="userName" id="userName"
												placeholder="Enter Username Here"> <span
												id="username" class="text-danger font-weight-bold"></span>
										</div>
										<!-- email -->

										<div class="form-group">
											<input type="password" class="form-control form-control-user"
												name="userPass" id="userPass"
												placeholder="Enter Password Here"> <span
												id="passwords" class="text-danger font-weight-bold"></span>
										</div>
										<div class="form-group">
											<!-- 
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me</label>
                      </div>
                       -->
										</div>
										<input class="btn btn-primary btn-user btn-block"
											type="submit" value="Login">
									</form>
									<hr>
									<!--
                  <div class="text-center">
                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                  </div>
                   -->
									<div class="text-center">
										<a class="small" href="register">Create Account</a>
									</div>







									<div class="text-center">
										<!-- Footer -->
										<footer
											class="w3-container w3-padding-64 w3-center w3-black w3-xlarge">
											<a href="#"><i class="fa fa-facebook-official"></i></a> <a
												href="#"><i class="fa fa-pinterest-p"></i></a> <a href="#"><i
												class="fa fa-twitter"></i></a> <a href="#"><i
												class="fa fa-flickr"></i></a> <a href="#"><i
												class="fa fa-linkedin"></i></a>
											<p class="w3-medium">
												Powered by <a
													href="https://www.w3schools.com/w3css/default.asp"
													target="_blank">b2b.com</a>
											</p>
										</footer>

										<script>
											// Automatic Slideshow - change image every 3 seconds
											var myIndex = 0;
											carousel();

											function carousel() {
												var i;
												var x = document
														.getElementsByClassName("mySlides");
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

									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>

		<script>
			function validation() {
				var user = document.getElementById('userName').value;
				var pass = document.getElementById('userPass').value;

				if (user == "") {
					document.getElementById('username').innerHTML = "Please enter username";
					return false;
				} else {
					document.getElementById('username').innerHTML = "";
				}
				if (!isNaN(user)) {
					document.getElementById('username').innerHTML = "only characters are allowed";
					return false;
				}

				if (pass == "") {
					document.getElementById('passwords').innerHTML = "Please enter password";
					return false;
				}
				if (pass.length<=4 || pass.length> = 21) {
					document.getElementById('passwords').innerHTML = "password must be between 5 and 20";
					return false;
				}
			}
		</script>

		<!-- To solve the backtracking issue -->
		<script type="text/javascript">
			function preventBack() {
				window.history.forward();
			}
			setTimeout("preventBack()", 0);
			window.onunload = function() {
				null
			};
		</script>

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

</html>