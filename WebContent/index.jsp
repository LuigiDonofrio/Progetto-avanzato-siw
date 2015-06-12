<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
					<a class="navbar-brand active" href="#">BuyMentor</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li><h:form>
								<button class="btn btn-link navbar-btn dropdown-toggle"
									type="button" id="dropdownMenu1" data-toggle="dropdown"
									aria-expanded="true">
									Dropdown <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#">Action</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#">Another action</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#">Something else here</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href="#">Separated link</a></li>
								</ul>

								<h:outputLink styleClass="btn btn-link navbar-btn"
									value='#{request.contextPath}/faces/newProduct.jsp'
									rendered="#{utenteController.showAdminOps}">Aggiungi prodotto </h:outputLink>

								<h:commandLink styleClass="btn btn-link navbar-btn"
									action="#{ordineController.listOrdini}"
									value="Tutti gli ordini"
									rendered="#{utenteController.showAdminOps}" />

								<h:commandLink styleClass="btn btn-link navbar-btn"
									action="#{productController.listProducts}"
									value="Tutti i prodotti" />

								<h:commandLink styleClass="btn btn-link navbar-btn"
									action="#{ordineController.prendiOrdiniCliente}"
									value="I miei Ordini" rendered="#{utenteController.showOrdini}" />
							</h:form></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
					<div class="navbar-form navbar-right">
						<!-- ${index.message} -->
						<span style="float: left;"><h:form>
								<h:outputLink value='#{request.contextPath}/faces/loginUser.jsp'
									styleClass="btn btn-success" rendered="#{!loginController.logged}">Login</h:outputLink>
								<h:commandLink action="#{loginController.logout}" value="Logout"
									styleClass="btn btn-success" rendered="#{loginController.logged}"/>
								<h:outputLink value='#{request.contextPath}/faces/registraCliente.jsp'
									styleClass="btn btn-link" rendered="#{!loginController.logged}">Registrati</h:outputLink>
							</h:form></span> <span style="float: right;"><h:form>
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
							</h:form></span>
					</div>
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
						<h1>Benvenuto!</h1>
						<p>Questa &#232 la pagina iniziale.</p>
					</div>


				</div>
				${index.carrello}
			</div>

		</div>
		<!--/row-->
		<h:form>
			<h:commandLink styleClass="btn btn-success"
				action="riepilogoOrdine.jsp" value="Conferma" />
		</h:form>
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






