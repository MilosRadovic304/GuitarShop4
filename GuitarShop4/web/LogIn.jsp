<%-- 
    Document   : LogIn
    Created on : Apr 15, 2018, 4:11:57 PM
    Author     : Milos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/registration.css" rel="stylesheet" type="text/css">
        <title>Log In</title>
        <%@ include file="header.jsp"%>
    </head>
    <body>
        <div class="b">
            <h1>Log In Form</h1>         
            <h3>Log In as admin (email = admin@admin.com and password = admin) to see full functionality <br>
                Or register first to log in as user
            
            </h3>
            <form name="login" action="login" method="get" id="reg_back"> 
                <input name="email"  placeholder="email" type="text" class="reg">
                <input name="pass"  placeholder="password" type="password" class="reg">  
                <input value="Log In"   type="submit" class="search_button"> 
            </form>      
        </div>
    </body>
    <%@ include file="footer.jsp"%>
</html>
