<%-- 
    Document   : GetAllGuitars2
    Created on : Apr 16, 2018, 3:25:08 PM
    Author     : Milos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/find.css" rel="stylesheet" type="text/css">
        <title>All Guitars</title>
        <%@ include file="header3.jsp"%>
    </head>
    
    <%String table = (String) request.getAttribute("table");%>
    
    <body>
        <h1>All Guitars:</h1>
        <div class="findtable">
            <p><%= table %></p>
            <a href="index3.jsp">Home</a>
        </div>
    </body>
    <%@ include file="footer.jsp"%>
</html>
