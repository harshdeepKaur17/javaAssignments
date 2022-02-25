<%@page import = "com.productApp.model.persistence.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Product product = (Product)session.getAttribute("product");
	out.print(product);
%>
</body>
</html>