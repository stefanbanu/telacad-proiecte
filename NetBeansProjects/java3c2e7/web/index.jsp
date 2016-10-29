<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    int global = 1;
%>


<%
    int pageVar = 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= global++ %></h1>
        <h1><%= pageVar++ %></h1>
        
        
    </body>
</html>
