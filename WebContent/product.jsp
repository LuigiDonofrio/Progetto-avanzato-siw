<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>
<f:view>
<h1>${productController.product.name}</h1>
<h2>Details</h2>
<div>Code: ${productController.product.code}</div>
<div>Price: ${productController.product.price}</div>
<div>Description: ${productController.product.description}</div>
<div> 
	<h:form>
		<h:inputText value="#{ordineController.productCode}" required="true" id="productCode" />
		<h:commandButton action="#{ordineController.createOrdine}" value="Aggiungi al carrello" />
	</h:form>
</div>
</f:view>
</body>
</html>