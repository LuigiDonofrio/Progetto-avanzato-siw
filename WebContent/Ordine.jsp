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
<title>BuyMentor - Riepilogo ordine</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/offcanvas.css" rel="stylesheet">
<link href="css/bootstrap-datepicker.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<f:view>
		<h:form>
			<table>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="linea" items="#{ordineController.righe}">
					<tr>
						<td><h:commandLink action="#{productController.findProduct}"
								value="#{linea.prodotto.name}">
								<f:param name="id" value="#{linea.prodotto.id}" />
							</h:commandLink></td>
				</c:forEach>
				<h:outputLabel for="d_evasione">Data di evasione</h:outputLabel>
				<h:inputText value="#{ordineController.dataEvasione}"
					styleClass="datepicker form-control" required="true"
					requiredMessage="La data di evasione &#232 obbligatoria"
					id="d_evasione" converterMessage="Formato: GG/MM/AAAA">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:inputText>
				<h:commandButton value="Evadi"
					action="#{ordineController.evadiOrdine}">
					<f:param name="id" value="#{ordineController.ordine.id}" />
				</h:commandButton>
			</table>
		</h:form>
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