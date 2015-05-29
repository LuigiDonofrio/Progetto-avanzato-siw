<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ page language="java" import="it.uniroma3.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>
<center><strong>Benvenuto:</strong>
${sessionScope.currentUser.name} ${sessionScope.currentUser.lastname} </center>
</body>
</html>