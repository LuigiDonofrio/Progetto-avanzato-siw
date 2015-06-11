<%@ page language="java" import="it.uniroma3.model.*" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ordine</title>
</head>
<body>
<f:view>
<h:form>
<table>
	<tr>
		<th>Name</th><th>Price</th>
	</tr>
	<c:forEach var="linea" items="#{ordineController.righe}">
		<tr><td>
		<h:commandLink action="#{productController.findProduct}" value="#{linea.prodotto.name}">
			<f:param name="id" value="#{linea.prodotto.id}" />
		</h:commandLink>
	</c:forEach>
</table>
</h:form>
</f:view>
</body>
</html>