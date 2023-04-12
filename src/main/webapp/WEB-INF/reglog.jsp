<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL -->
<!-- c: -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Form/Submit workflows -->
<!-- form: -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- The&nbsp;'isErrorPage'&nbsp;attribute indicates that the current JSP can be used as the error page for another JSP. -->
<%@ page isErrorPage="true" %>
<!-- The&nbsp;errorPage&nbsp;attribute tells the JSP engine which page to display if there is an error while the current page runs. The value of the errorPage attribute is a relative URL. -->
<%@ page errorPage = "MyErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register and Login</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<div class="welcomeHeader">
			<h1>Book Club</h1>
			<h3>A place for friends to share thoughts on books</h3>
		</div>
		<div class="welcomeMain row">
			<div class="col">
				<h2 class="fs-3">Register</h2>
				<form:form action="/register" method="POST" modelAttribute="registerUser">
					<div class="row my-4">
						<form:label path="name" class="cal-3">Name : </form:label>
						<form:errors path="name" class="text-danger"/>
						<form:input path="name" class="col-8"/>
					</div>
					<div class="row my-4">
						<form:label path="email" class="cal-3">Email : </form:label>
						<form:errors path="email" class="text-danger"/>
						<form:input path="email" type="email" class="col-8"/>
					</div>
					<div class="row my-4">
						<form:label path="password" class="cal-3">Password : </form:label>
						<form:errors path="password" class="text-danger"/>
						<form:password path="password" class="col-8"/>
						<!-- if using 'form:password', no need to make 'form:input type="password"' -->					
					</div>
					<div class="row my-4">
						<form:label path="confirmPassword" class="cal-3">Confirm Password : </form:label>
						<form:errors path="confirmPassword" class="text-danger"/>
						<form:password path="confirmPassword" class="col-8"/>					
					</div>
					<input type="submit" class="btn btn-secondary" />
				</form:form>
			</div>
			<div class="col">
				<h2 class="fs-3">Login</h2>
			</div>
			
		</div>
	
	</div>
</body>
</html>