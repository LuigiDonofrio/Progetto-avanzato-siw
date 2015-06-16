<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>BuyMentor - Anagrafica cliente</title>

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
										${currentUser.name} ${currentUser.lastname} <span
											class="caret"></span>
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
									rendered="#{utenteController.userLogged && utenteController.adminLogged}">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
										${currentUser.name} ${currentUser.lastname} <span
											class="caret"></span>
									</button>
								</h:panelGroup>
								<ul class="dropdown-menu" role="menu">
									<li><h:outputLink
											value='#{request.contextPath}/faces/newProduct.jsp'>
											Aggiungi prodotto </h:outputLink></li>
									<li class="divider" />
									<li><h:outputLink
											value='#{request.contextPath}/faces/registraAmministratore.jsp'>
											Registra nuovo Admin </h:outputLink></li>
									<li><h:outputLink
											value='#{request.contextPath}/faces/newFornitore.jsp'>
											Registra nuovo fornitore </h:outputLink></li>
									<li class="divider" />
									<li><h:commandLink
											action="#{utenteController.ottieniClienti}"
											value="Anagrafica Clienti" /></li>
									<li><h:commandLink
											action="#{utenteController.ottieniClientiDaApprovare}"
											value="Clienti da approvare" /></li>
									<li class="divider" />
									<li><h:commandLink
											action="#{ordineController.ottieniOrdini}"
											value="Tutti gli ordini" /></li>
									<li><h:commandLink
											action="#{ordineController.ottieniOrdiniNonEvasi}"
											value="Ordini da evadere" /></li>
									<li class="divider" />
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
						<h2>${utenteController.cliente.name}
							${utenteController.cliente.lastname}</h2>
						<h:form>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Dettagli</h3>
								</div>
								<div class="panel-body">
									<div>
										<b>Username:</b> ${utenteController.cliente.nickname}
									</div>
									<div>
										<b>Nome:</b> ${utenteController.cliente.name}
									</div>
									<div>
										<b>Cognome:</b> ${utenteController.cliente.lastname}
									</div>
									<div>
										<b>Indirizzo:</b> ${utenteController.cliente.address}
									</div>
									<div>
										<b>Data di Nascita:</b>
										<h:outputFormat value="{0, date, dd/MM/yyyy}">
											<f:param value="#{utenteController.cliente.dataNascita}" />
										</h:outputFormat>
									</div>
									<div>
										<b>Data di Registrazione:</b>
										<h:outputFormat value="{0, date, dd/MM/yyyy}">
											<f:param
												value="#{utenteController.cliente.dataRegistrazione}" />
										</h:outputFormat>
									</div>

								</div>
							</div>
							<h:commandLink action="#{utenteController.approvaCliente}"
								rendered="#{not utenteController.cliente.approvato}"
								value="Approva" styleClass="btn btn-success">
								<f:param name="id" value="#{utenteController.cliente.id}" />
							</h:commandLink>
						</h:form>
					</div>
				</div>

				<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
					<div class="panel panel-default">
						<div class="panel-heading">
							<table style="width: 100%">
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
							<table style="width: 100%">
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
	</f:view>
</body>
</html>