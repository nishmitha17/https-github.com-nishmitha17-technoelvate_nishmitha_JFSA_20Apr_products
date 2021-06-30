<%@page import="com.te.productweb.beans.ProductInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String name = "Welcome to Technoelevate";
List<ProductInfoBean> infoBeans = (List) request.getAttribute("infos");
%>
<%@ include file="header1.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
</head>
<body>
	<fieldset>
		<h1 style="color: maroon; text-decoration: underline;">
			
			<%=name%></h1>
	</fieldset>

	<%
		if (infoBeans != null) {
	%>
	<fieldset>
		<legend>All Records</legend>
		<table  border="1" style="width:100%">
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Product Manufacture Date</th>
				<th>Product Expire Date</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Product accesstype</th>
			</tr>
			<%
				for (ProductInfoBean infoBean : infoBeans) {
			%>
			<tr>
				<td><%=infoBean.getId()%></td>
				<td><%=infoBean.getPname()%></td>
				<td><%=infoBean.getMyDate()%></td>
				<td><%=infoBean.getExDate()%></td>
				<td><%=infoBean.getPrice()%></td>
				<td><%=infoBean.getQuantity()%></td>
				<td><%=infoBean.getAccessType()%></td>
			</tr>
			<%
				}
			%>
		</table>

	</fieldset>
	<%
		}
	%>
</body>
</html>