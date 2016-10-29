<%-- 
    Document   : index
    Created on : Oct 14, 2016, 7:06:14 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <p>NUME: <input type="text" name="nume" /></p>
            <p><input type="submit" value="Salut" /></p>
        </form>
        
        <%
            if(request.getParameter("nume") != null){
                out.println("<h1>Salut, "+request.getParameter("nume")+"!</h1>");
            }
        %>
    </body>
</html>
