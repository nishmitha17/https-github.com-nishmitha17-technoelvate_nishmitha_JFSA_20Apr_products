<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login product </title>
<% String Msg=(String) request.getAttribute("errMsg");
String msg=(String) request.getAttribute("msg");

%>
</head>
<body>
<h3 style="color:black; color:red">
   <% if(Msg!=null && !Msg.isEmpty()) {
%>
<%=  Msg %>
<%} %>

</h3>
<h3 style="color:black; color:red">
   <% if(msg!=null && !msg.isEmpty()) {
%>
<%=  msg %>
<%} %>

</h3>


    <fieldset>
    
       <legend style="text-align:center">Login Form</legend>
       <form action="./login" method="post">
          <table>
            <tr> 
            <td>Product Id</td>
            <td>:</td>
            <td><input type="number" name="id" required="required"></td>
            </tr>
            
            <tr> 
            <td> Access Type</td>
            <td>:</td>
            <td><input type="text" name="accessType" required="required"></td>
            </tr>
          
           
          
          </table>
           
          <button type="submit" style="color:black; background-color:lightgreen">Login</button>
           
       
       
       </form>
    
    </fieldset>
</body>
</html>