<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiungi fornitore a Prodotto</title>
</head>
<body>
<f:view>
<h:form>
Id fornitore: <h:inputText value="#{fornitoreController.id_f}" 
                     required="true"
                     requiredMessage="Id f is mandatory"
                     id="idf"/> <h:message for="idf" />
id prodotto: <h:inputText value="#{fornitoreController.id_p}" 
                     required="true"
                     requiredMessage="Id p is mandatory"
                     id="idp"/> <h:message for="idp" />
                     
<h:commandButton value="Submit"  action="#{fornitoreController.addProdotto}"/>
</h:form>
</f:view>
</body>
</html>