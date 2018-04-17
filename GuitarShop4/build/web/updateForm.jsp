<%-- 
    Document   : updateForm.jsp
    Created on : Apr 11, 2018, 3:41:47 PM
    Author     : Milos
--%>

<%@page import="model.Customers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Customers customer = (Customers) request.getAttribute("customer");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/registration.css" rel="stylesheet" type="text/css">
        <title>Update</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <h1>Update form</h1>
        
        <div class="b">
            <form name="update" action="updateCustomer" method="get" id="reg_back">
                <input name="id"  value="<%=customer.getId()%>" type="text" class="reg" readonly>
                <input name="name"  value="<%=customer.getFirst_name()%>" type="text" class="reg">
                <input name="last"  value="<%=customer.getLast_name()%>" type="text" class="reg"> 
                <input name="pass"  value="<%=customer.getPassword()%>" type="password" class="reg"> 
                <input name="email"  value="<%=customer.getEmail_address()%>" type="text" class="reg"> 
                <input value="Update"   type="submit" class="search_button"> 
            </form>
        </div>
    </body>
    <%@ include file="footer.jsp"%>
</html>
