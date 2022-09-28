<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Customer-List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
.data {
	font-size: large;
	color: white;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
</style>
</head>

<body>
	<div class="container p-3 my-3 bg-primary text-white">
		<h2 style="text-align: center;">Customer Relationship Management</h2>
		<hr style="background-color: white; height: 2px;">

		<p>
			<a class="btn btn-secondary btn-outline-warning btn-lg"
				href="showCustomerForm">Add Customer</a>
		</p>
		<hr style="background-color: white; height: 2px;">
		<div class="container">
			<table class="table data">
				<thead>
					<tr>
						<th>S.No</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach var="customer" items="${customers}" varStatus="c">
					<tbody>
						<tr>
							<td>${c.count}</td>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.eMail}</td>
							<td><a class="btn btn-warning"
								href="update?id=${customer.id}">Update</a> | <a
								class="btn btn-danger" href="delete?id=${customer.id}"
								onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>