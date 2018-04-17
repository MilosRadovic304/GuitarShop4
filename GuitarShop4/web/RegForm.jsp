<%-- 
    Document   : Reg
    Created on : Feb 3, 2018, 4:18:02 PM
    Author     : Milos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/registration.css" rel="stylesheet" type="text/css">
        <title>Register</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <div class="b">
            <h1>Registration Form</h1>
            
            <img src="images/ibanez.png" id="ibn" alt="Ibanez">           
            
            <form name="register" action="add2" method="get" id="reg_back">
                <input name="name"  placeholder="Enter your name" type="text" class="reg">
                <input name="last"  placeholder="Last name" type="text" class="reg"> 
                <input name="pass"  placeholder="password" type="password" class="reg"> 
                <input name="email"  placeholder="email" type="text" class="reg"> 
                <input value="Registration"   type="submit" class="search_button"> 
            </form>      
        </div>
    </body> 
    <%@ include file="footer.jsp"%>
</html>
