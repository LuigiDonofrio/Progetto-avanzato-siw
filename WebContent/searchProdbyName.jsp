<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cerca prodotto per nome</title>
</head>
<body>
<h1>Cerca prodotti per nome</h1>

<f:view>
	<h:form>
		<div>
			Nome da ricercae: <h:inputText value="#{productController.name}" required="true"
                     requiredMessage="Name is mandatory"
                     id="nome"/> <h:message for="nome" />
		</div>
		<div>
			<h:commandButton value="Search"  action="#{productController.findProductbyName}"/>	
		</div>
</h:form>
</f:view>
</body>
</html>