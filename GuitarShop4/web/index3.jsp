<%-- 
    Document   : index3
    Created on : Apr 15, 2018, 4:05:43 PM
    Author     : Milos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/home.css" rel="stylesheet" type="text/css">
        <%@ include file="header3.jsp"%>
        <title>Administrator home page</title>
    </head>
    <body>
        <div class="b">
            <img src="images/strat3.jpg"  alt="Stratocaster" class="image_strat" >
            
            <form action="GuitarFind3" method="get">   
                <input name= "guitar_name" class="inp" placeholder="Enter guitar name..." type="text"> 
                <input type="submit" value="SEARCH" class="search_button">                
            </form>
        </div>
    </body>
    <%@ include file="footer.jsp"%>
</html>
