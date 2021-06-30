<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="header1.jsp" %>   
  
  <% String msg=(String) request.getAttribute("msg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:black; color:red">
   <% if(msg!=null && !msg.isEmpty()) {
%>
<%=  msg %>
<%} %>
<h3 style="color:black; color:red">
   <% if(msg!=null && !msg.isEmpty()) {
%>
<%=  msg %>
<%} %>

</h3>
<br>
<br>
<form action="./delete" method="get">
          <table>
            <tr> 
            <td>Product Id</td>
            <td>:</td>
            <td><input type="number" name="id" required="required"></td>
            </tr>
          </table>
          <br>
           <button type="submit" style="color:black; background-color:skyblue">submit</button>
  </form>
</body>
</html>