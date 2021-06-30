<%@page import="com.te.productweb.beans.ProductInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%ProductInfoBean product=(ProductInfoBean)request.getAttribute("product"); %>
<body>
   <br>
   <br>
   <table border="1">
   <tr>
   <th>Product Id</th>
   <th>Product Name</th>
   <th>Product M.R.Date</th>
   <th>Product Ex.Date</th>
   <th>Product Price</th>
    <th>Product Quantity</th>
   </tr>
   
   <tr>
   <th><%=product.getId() %></th>
   <th><%=product.getPname() %></th>
   <th><%=product.getMyDate() %></th>
   <th><%= product.getExDate()%></th>
   <th><%= product.getPrice()%></th>
   <th><%= product.getQuantity()%></th>
   <tr>
   </table>
</body>
</html>