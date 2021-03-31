<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page import="java.util.List"%>
<%@page import="com.b2b.service.ApprovalServiceImple"%>
<%@page import="com.b2b.service.ApprovalService"%>
<%@page import="com.b2b.dto.Approval"%>
<%@page import="javax.swing.text.html.ListView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<style>
* {
	box-sizing: border-box;
}

.zoom {
	padding: 50px;
	transition: transform .2s;
	width: 300px;
	height: 300px;
	margin: 0 auto;
}

.zoom:hover {
	-ms-transform: scale(3.0); /* IE 9 */
	-webkit-transform: scale(3.0); /* Safari 3-8 */
	transform: scale(3.0);
}
</style>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home</title>

<!-- Custom fonts for this template-->
<link href="resources/theme1//vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/theme1/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-text mx-3">b2b Medical Supplies</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">



		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<h3>Welcome ${userName}</h3>

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>



					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">






						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->

						<!-- Dropdown - User Information -->
						<div style="justify-content: center; align-content: center">
							<a class="btn btn-primary btn-user btn-block" href="logout">Logout</a>
						</div>


					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">Admin Home Page</h1>

				</div>
				<!-- /.container-fluid -->






				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Account Verification</h1>
					<br>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3"></div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>User Type</th>
											<th>User Name</th>
											<th>Address</th>
											<th>License</th>
											<th>Accept Request</th>
											<th>Reject Request</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${ilist}" var="approval">
											<tr>
												<td>${approval.tempType }</td>
												<td>${approval.tempName }</td>
												<td>${approval.tempAddr }</td>
												<td>
													<div class="zoom">
														<img width="200" height="200" alt="license"
															src="<c:url value = "resources/images/${approval.license}"/>">
													</div> <!-- <input class="btn btn-primary btn-user btn-block" type="button" value="Check License"> -->

												</td>
												<td>
													<form action="createAccount" method="post">
														<input type="hidden" name="tempName"
															value="${approval.tempName}"> <input
															type="hidden" name="tempType"
															value="${approval.tempType}"> <input
															class="btn btn-success btn-user btn-block" type="submit"
															value="Create Account">
													</form>
												</td>
												<td>
													<form action="rejectAccount" method="post">
														<input type="hidden" name="tempName"
															value="${approval.tempName}"> <input
															type="hidden" name="tempType"
															value="${approval.tempType}"> <input
															class="btn btn-danger btn-user btn-block" type="submit"
															value="Reject Account">
													</form>
												</td>
												<!-- 
	                       <div>
        						<img alt="license" src="<c:url value = "resources/images/${approval.license}"/>">	
					       </div>
         -->
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- 
        <script type="text/javascript">
	        function Change()
	        {
	        document.getElementById("change").height="600";
	        document.getElementById("change").width="600";
	        }
	        function Revert()
	        {
	        document.getElementById("change").height="100";
	        document.getElementById("change").width="100";
	        }
        </script>
         -->
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; b2b Medical Supplies</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
  	function preventBack() { window.history.forward(); }
  	setTimeout("preventBack()", 0);
  	window.onunload = function() { null };
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
