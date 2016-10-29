<%-- 
    Document   : index
    Created on : Oct 14, 2016, 6:43:22 PM
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
        <p><a href="index.jsp?nume=Tom">Tom</a></p>
        <p><a href="index.jsp?nume=Erik">Erik</a></p>
        <p><a href="index.jsp?nume=John">John</a></p>
        
        <h1>
            <%
                if(request.getParameter("nume") != null){
                    out.println("Hello, "+request.getParameter("nume"));
                }
            %>
        </h1>
    </body>
</html>
