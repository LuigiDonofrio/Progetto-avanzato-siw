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
<title>Tutti gli ordini</title>

<!-- Bootstrap -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link
	href="https://raw.githubusercontent.com/Eonasdan/bootstrap-datetimepicker/master/build/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>



	<f:view>
		<table>
			<h:form>
				<th>ID</th>
				<th>Cliente</th>
				<c:forEach var="ordine" items="#{ordineController.ordini}"
					varStatus="status">			
					
					<tr>
						<td><h:commandLink action="#{ordineController.findOrdine}"
								value="#{ordine.id}">
								<f:param name="id" value="#{ordine.id}" />
							</h:commandLink></td>
						<td><h:commandLink action="#{utenteController.findCliente}"
								value="#{ordine.cliente.nickname}">
								<f:param name="id" value="#{ordine.cliente.id}" />
							</h:commandLink></td>

						<td>${ordine.dataApertura}</td>
						
						<td><h:commandLink action="#{ordineController.findOrdine}" styleClass="btn btn-success"
								value="Evadi">
								<f:param name="id" value="#{ordine.id}" />
							</h:commandLink></td>
					</tr>
				</c:forEach>
			</h:form>
		</table>
	</f:view>





	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script
		src="https://raw.githubusercontent.com/moment/moment/develop/moment.js"></script>
	<script
		src="https://raw.githubusercontent.com/moment/moment/master/locale/id.js"></script>
	<script
		src="https://raw.githubusercontent.com/Eonasdan/bootstrap-datetimepicker/master/build/js/bootstrap-datetimepicker.min.js"></script>

</body>
</html>