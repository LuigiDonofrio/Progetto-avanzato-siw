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
<title>BuyMentor - Registrazione</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/offcanvas.css" rel="stylesheet">
<link href="css/bootstrap-datepicker.css" rel="stylesheet">

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
		<!-- Fixed navbar -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<h:form>
						<h:outputLink styleClass="navbar-brand"
							value='#{request.contextPath}/faces/index.jsp'>BuyMentor</h:outputLink>
					</h:form>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><h:form>
								<h:commandLink styleClass="btn btn-link navbar-btn"
									action="#{productController.listProducts}"
									value="Catalogo prodotti" />
							</h:form></li>
					</ul>
					<span class="nav navbar-form navbar-right"> <h:form>
							<div class="btn-group">
								<h:panelGroup
									rendered="#{utenteController.userLogged && !utenteController.adminLogged}">
									<button type="button" class="btn btn-success dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
										${currentUser.nickname} <span class="caret"></span>
									</button>
								</h:panelGroup>
								<ul class="dropdown-menu" role="menu">
									<li><h:commandLink
											action="#{ordineController.prendiOrdiniCliente}"
											value="Cronologia ordini" /></li>
									<li class="divider"></li>
									<li><h:commandLink action="#{loginController.logout}"
											value="Logout" /></li>
								</ul>
							</div>
							<div class="btn-group">
								<h:panelGroup
									rendered="#{utenteController.userLogged && utenteController.adminLogged}">>
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
										${currentUser.nickname} <span class="caret"></span>
									</button>
								</h:panelGroup>
								<ul class="dropdown-menu" role="menu">
									<li><h:outputLink
											value='#{request.contextPath}/faces/newProduct.jsp'>
											Aggiungi prodotto </h:outputLink></li>
									<li class="divider"></li>
									<li><h:outputLink
											value='#{request.contextPath}/faces/registraAmministratore.jsp'>
											Registra nuovo Admin </h:outputLink></li>
									<li class="divider"></li>
									<li><h:outputLink
											value='#{request.contextPath}/faces/newFornitore.jsp'>
											Registra nuovo fornitore </h:outputLink></li>
									<li><h:commandLink
											action="#{utenteController.ottieniClienti}"
											value="Anagrafica Clienti" /></li>
									<li class="divider"></li>
									<li><h:commandLink
											action="#{ordineController.ottieniOrdini}"
											value="Tutti gli ordini" /></li>
									<li><h:commandLink
											action="#{ordineController.ottieniOrdiniNonEvasi}"
											value="Ordini da evadere" /></li>
									<li class="divider"></li>
									<li><h:commandLink action="#{loginController.logout}"
											value="Logout" /></li>
								</ul>
							</div>
							<h:outputLink value='#{request.contextPath}/faces/loginUser.jsp'
								styleClass="btn btn-success"
								rendered="#{!utenteController.userLogged}">Login</h:outputLink>
							<h:outputLink
								value='#{request.contextPath}/faces/registraCliente.jsp'
								styleClass="btn btn-link"
								rendered="#{!utenteController.userLogged}">Registrati</h:outputLink>
						</h:form>
					</span>
				</div>
			</div>
		</nav>
		<!--/.nav-collapse -->

		<div class="container">
			<div class="row row-offcanvas row-offcanvas-right">
				<div class="col-xs-12 col-sm-9">
					<p class="pull-right visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">Toggle nav</button>
					</p>
					<div class="jumbotron">
						<h2>Registrazione</h2>
						<h:form>
							<div>
								<h:outputLabel for="username">Username</h:outputLabel>
								<h:inputText value="#{utenteController.nickname}"
									styleClass="form-control" required="true"
									requiredMessage="L'username &#232 obbligatorio" id="username" />
								<h:message for="username" />
							</div>
							<div>
								<h:outputLabel for="password">Password</h:outputLabel>
								<h:inputSecret value="#{utenteController.password}"
									styleClass="form-control" required="true"
									requiredMessage="La password &#232 obbligatoria"
									validator="#{utenteController.supportValidatePassword}"
									id="password" />
								<h:message for="password" />
							</div>
							<div>
								<h:outputLabel for="passwordRep">Ripeti password</h:outputLabel>
								<h:inputSecret value="#{utenteController.passwordRep}"
									styleClass="form-control"
									validator="#{utenteController.validatePassword}"
									id="passwordRep" />
								<h:message for="passwordRep" />
							</div>
							<div>
								<h:outputLabel for="name">Nome</h:outputLabel>
								<h:inputText value="#{utenteController.name}"
									styleClass="form-control" required="true"
									requiredMessage="Il nome &#232 obbligatorio" id="name" />
								<h:message for="name" />
							</div>
							<div>
								<h:outputLabel for="cognome">Cognome</h:outputLabel>
								<h:inputText value="#{utenteController.lastname}"
									styleClass="form-control" required="true"
									requiredMessage="Il cognome &#232 obbligatorio" id="cognome" />
								<h:message for="cognome" />
							</div>
							<div>
								<h:outputLabel for="d_nascita">Data di nascita</h:outputLabel>
								<h:inputText value="#{utenteController.dataNascita}"
									styleClass="datepicker form-control" required="true"
									requiredMessage="La data di nascita &#232 obbligatoria"
									id="d_nascita" converterMessage="Formato: GG/MM/AAAA">
									<f:convertDateTime pattern="dd/MM/yyyy" />
								</h:inputText>
								<h:message for="d_nascita" />
							</div>
							<div>
								<h:outputLabel for="address">Indirizzo</h:outputLabel>
								<h:inputText value="#{utenteController.address}"
									styleClass="form-control" required="true"
									requiredMessage="L'indirizzo &#232 obbligatorio" id="address" />
								<h:message for="address" />
							</div>
							<div>
								<h:outputLabel for="email">E-mail</h:outputLabel>
								<h:inputText value="#{utenteController.email}"
									styleClass="form-control" required="true"
									requiredMessage="L'email &#232 obbligatoria" id="email" />
								<h:message for="email" />
							</div>
							<br>
							<h:commandButton value="Invia"
								action="#{utenteController.creaCliente}"
								styleClass="btn btn-lg btn-primary btn-block" />
						</h:form>
					</div>
				</div>
				
				<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
					<div class="panel panel-default">
						<div class="panel-heading">
								<table style="width:100%">
									<tr>
										<td width="70%"><h3 class="panel-title">Carrello</h3></td>
										<td width="30%" align="right"><span
											class="glyphicon glyphicon-shopping-cart" aria-hidden="true"
											style="float: right"></span></td>
									</tr>
								</table>
						</div>
						<div class="panel-body">${index.carrello}</div>
						<h:form>
							<table style="width:100%">
								<tr>
									<td width="55%" align="center"><h:commandLink
											styleClass="btn btn-success" action="riepilogoOrdine.jsp"
											value="Conferma" rendered="#{ordineController.valido}" /></td>
									<td width="45%" align="center"><h:commandLink
											styleClass="btn btn-success"
											action="#{ordineController.svuotaCarrello()}" value="Svuota"
											rendered="#{ordineController.valido}" /></td>
								</tr>
							</table>
						</h:form>
					</div>
					<!--/panel-->
				</div>
				<!--/sidebar-->

				<hr>
				<footer>
					<p>&copy; Company 2014</p>
				</footer>
			</div>
			<!--/row-->
		</div>
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
		<script src="js/bootstrap-datepicker.js"></script>
		<script src="js/locales/bootstrap-datepicker.it.min.js"
			charset="UTF-8"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.datepicker').datepicker({
					format : "dd/mm/yyyy",
					language : "it",
					toggleActive : true
				});
			});
		</script>
	</f:view>
</body>
</html>