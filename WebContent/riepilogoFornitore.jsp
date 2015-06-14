<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Nome fornitore</b>: ${fornitoreController.fornitore.name}<br>
<b>Partita IVA</b>:${fornitoreController.fornitore.p_iva}<br>
<b>Indirizzo</b>: ${fornitoreController.fornitore.indirizzo}<br>
<b>Telefono</b>: ${fornitoreController.fornitore.telefono}<br>
<b>Email</b>: ${fornitoreController.fornitore.email}<br>
</body>
</html>