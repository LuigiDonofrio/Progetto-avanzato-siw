<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Product</title>
</head>
<body>
<f:view>
<h:form>
    <div>Nome del fornitore: <h:inputText value="#{fornitoreController.nome}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
    <div>Partita iva: <h:inputText value="#{fornitoreController.p_iva}" 
                     required="true"
                     requiredMessage="Code is mandatory"
                     id="p_iva"/> <h:message for="p_iva" />
	</div>
    <div>Indirizzo: <h:inputText value="#{fornitoreController.indirizzo}" 
                     required="true"
                     requiredMessage="Indirizzo is mandatory"
                     id="indirizzo"/> <h:message for="indirizzo" />
	</div>
    <div>email: <h:inputText value="#{fornitoreController.email}" 
    				required="true"
                     requiredMessage="Email is mandatory"       
                     id="email"/> <h:message for="email" />                 
	</div>
	
	<div>telefono: <h:inputText value="#{fornitoreController.telefono}" 
    				required="true"
                     requiredMessage="telefono is mandatory"       
                     id="telefono"/> <h:message for="telefono" />  
	
	<div>
		<h:commandButton value="Submit"  action="#{fornitoreController.createFornitore}"/>
	</div>
	
	               
	</div>
	
</h:form>
</f:view>
</body>
</html>