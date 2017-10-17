<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<br /> <a type="button" class="btn btn-primary"
			href="/courses/create">Add New Course</a> <br />
		<h1>All Courses</h1>
		
		${successmsg}
		${errormsg}
		<table class="table"> 

			<thead>
				<tr>
					<th>#</th>
					<th>Title</th>
					<th>Description</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="no" value="1"></c:set>
				<c:forEach var="course" items="${courseslist}">
					<tr>

						<th scope="row">${no}</th>
						<td>${course.title }</td>
						<td>${course.description }</td>
						<td><a type="button" class="btn btn-info"
							href="/courses/${course.id }">View</a></td>
						<td><a type="button" class="btn btn-success"
							href="/courses/edit/${course.id }">Edit</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/courses/delete/${course.id }">Delete</a></td>

						<c:set var="no" value="${no+1}"></c:set>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>