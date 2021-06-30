<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String Msg=(String) request.getAttribute("errMsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:black; color:red">
   <% if(Msg!=null && !Msg.isEmpty()) {
%>
<%=  Msg %>
<%} %>
</h3>
  <form action="./search" method="get">
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