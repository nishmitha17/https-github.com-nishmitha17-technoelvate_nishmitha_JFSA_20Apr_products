<%@page import="com.te.productweb.beans.ProductInfoBean"%>
<%@page import="org.jboss.jandex.TypeTarget.Usage"%>
<%@page import="com.te.productweb.beans.ProductInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
ProductInfoBean  infoBean= (ProductInfoBean) request.getAttribute("id");
%>
<%@ include file="header1.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Data</title>
</head>
<body>
	<fieldset>
		<legend>Add Details </legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Product Id</td>
					<td>:</td>
					<td><%=infoBean.getId()	%></td>
					<td><input type="hidden" name="id" value=<%=infoBean.getId()%>></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td>:</td>
					<td><input type="text" name="pname"
						value=<%=infoBean.getPname()%>></td>
				</tr>
				<tr>
					<td>Product Manfacture Date</td>
					<td>:</td>
					<td><input type="hidden" name="myDate"
						value=<%=infoBean.getMyDate()%>></td>
				</tr>
				<tr>
					<td>Product Expire Date</td>
					<td>:</td>
					<td><input type="date" name="exDate" 
					value=<%=infoBean.getExDate()%>></td>
					
				</tr>
				<tr>
					<td>Product Price</td>
					<td>:</td>
					<td><input type="number" name="price" value=<%=infoBean.getPrice()%>></td>
				</tr>
				<tr>
					<td>Product Quantity</td>
					<td>:</td>
					<td><input type="number" name="quantity" value=<%=infoBean.getQuantity()%>></td>
				</tr>
				<tr>
				
					<td>Product Access</td>
					<td>:</td>
					<td><input type="hidden" name="accessType" value=<%=infoBean.getAccessType()%>></td>
				</tr>
				<tr>
				<td><input type="submit" value="submit"></td>
			</table>
		</form>
	</fieldset>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: magenta;"><%=msg%>
	</h1>
	<%
		}
	%>

</body>
</html>