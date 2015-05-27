<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrazione nuovo utente</title>
</head>
<body>


<f:view>
	<h:form>
	
		<div>Nickname: <h:inputText value="#{utenteController.nickname}" 
                     required="true"
                     requiredMessage="Nickname is mandatory"
                     id="nickname"/> <h:message for="nickname" />
		</div>
		
	 <div>Name: <h:inputText value="#{utenteController.name}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
		</div>
		
		<div>Lastname: <h:inputText value="#{utenteController.lastname}" 
                     required="true"
                     requiredMessage="Lastname is mandatory"
                     id="lastname"/> <h:message for="lastname" />
		</div>
		
		<div>Address: <h:inputText value="#{utenteController.address}" 
                     required="true"
                     requiredMessage="Address is mandatory"
                     id="address"/> <h:message for="address" />
		</div>
		
		<div>Password: <h:inputSecret value="#{utenteController.password}" 
                     required="true"
                     requiredMessage="You did not specify a password"
                     id="password"/> <h:message for="password" />
		</div>
		
		<h:commandButton value="Submit"  action="#{utenteController.createUser}"/>	
</h:form>
</f:view>		
		
</body>
</html>