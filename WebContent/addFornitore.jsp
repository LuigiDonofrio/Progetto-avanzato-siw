<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiungi fornitore a Prodotto</title>
</head>
<body>
<f:view>
<h:form>
<table>
<c:forEach var="fornitore" items="#{productController.allFornitori}">
<tr><td>
	<b>${fornitore.name}</b> <h:commandLink styleClass="btn btn-success" value="Aggiungi" action="#{fornitoreController.addProdotto}">
	<f:param name="id_f" value="#{fornitore.id}"/>
	<f:param name="id_p" value = "#{productController.id}"/>
	</h:commandLink>
	</td>
	</tr>
	</c:forEach>
	</table>
</h:form>
</f:view>
</body>
</html>