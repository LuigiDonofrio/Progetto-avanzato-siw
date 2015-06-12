<%@page import="it.uniroma3.controller.OrdineController"%>
<%@page import="it.uniroma3.controller.ProductController"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:p="http://primefaces.org/ui"
	xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:p="http://primefaces.org/ui">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Off Canvas Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/offcanvas.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<f:view>
		<nav class="navbar navbar-fixed-top navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Project name</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href='<c:url value="/faces/newProduct.jsp" />'>New
								Product</a></li>
						<li><h:form>
								<h:commandLink styleClass="btn btn-default navbar-btn"
									action="#{productController.listProducts}"
									value="List all Products" />
							</h:form></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
					<div class="navbar-form navbar-right">
						${interfaccia.message}

						<div class="col-lg-6">

							<h:form>
								<div class="input-group">

									<h:inputText styleClass="form-control"
										value="#{productController.name}" required="true"
										requiredMessage="Name is mandatory" id="nome" />
									<h:message for="nome" />
									<span class="input-group-btn"> <h:commandButton
											styleClass="btn btn-default"
											action="#{productController.findProductbyName}" value="Cerca" />
									</span>

								</div>
								<!-- /input-group -->
							</h:form>

						</div>
						<!-- /.col-lg-6 -->


					</div>



				</div>
				<!-- /.nav-collapse -->
			</div>
			<!-- /.container -->
		</nav>
		<!-- /.navbar -->

		<div class="container">

			<div class="row row-offcanvas row-offcanvas-right">

				<div class="col-xs-12 col-sm-9">
					<p class="pull-right visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">Toggle nav</button>
					</p>
					${message}
					<div class="jumbotron">

						<h1>${productController.product.name}</h1>
						<h2>Details</h2>
						<div>Code: ${productController.product.code}</div>
						<div>Price: ${productController.product.price}</div>
						<div>Description: ${productController.product.description}</div>
						<div>
							<h:form>
								<c:set scope="session" var="code"
									value="${productController.product.code}" />
								<h:commandButton styleClass="btn btn-success" action="#{ordineController.aggiungiProdotto(code)}"
									value="Aggiungi al carrello" />
							</h:form>
						</div>

					</div>

				</div>
				${interfaccia.carrello}
			</div>

			<!--/row-->

		</div>
		<hr>
		<footer>
			<p>&copy; Company 2014</p>
		</footer>
		<!--/.container-->


		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>

		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src="js/ie10-viewport-bug-workaround.js"></script>

		<script src="js/offcanvas.js"></script>
	</f:view>
</body>
</html>
