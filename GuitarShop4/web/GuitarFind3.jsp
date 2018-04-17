<%-- 
    Document   : GuitarFind3
    Created on : Apr 17, 2018, 12:29:01 AM
    Author     : Milos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Find guitars</title>
        <link href="CSS/find.css" rel="stylesheet" type="text/css">
        <%@ include file="header3.jsp"%>
    </head>
    
    <%String table = (String) request.getAttribute("table");%>
    
    <body>
        <h1>Guitars are here:</h1>
        
        <div class="findtable">
            <p><%= table %></p>
            <a href="index3.jsp">Home</a>
        </div>
    </body>
    <%@ include file="footer.jsp"%>
</html>
