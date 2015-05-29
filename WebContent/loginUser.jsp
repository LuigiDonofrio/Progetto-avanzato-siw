<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://getbootstrap.com/favicon.ico">

<title>Cover Template for Bootstrap</title>


<link href="css/bootstrap.css" rel="stylesheet">

<link href="css/signin.css" rel="stylesheet">

<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>


	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<f:view>
				<h:form>
					<h:outputLabel for="username">Username:</h:outputLabel>
					<h:inputText id="username" value="#{loginController.username}"
						styleClass="form-control" />

					<h:outputLabel for="password">Password:</h:outputLabel>

					<h:inputText id="password" value="#{loginController.password}"
						styleClass="form-control" />
					<h:selectBooleanCheckbox value="#{loginController.isAdmin}" id="isAdmin"/> Login come Admin?
					</div>


					<h:commandButton value="Login"
						action="#{loginController.loginUtente}"
						styleClass="btn btn-lg btn-primary btn-block" />

				</h:form>
			</f:view>
	</div>
	<!-- /container -->


</body>
</html>