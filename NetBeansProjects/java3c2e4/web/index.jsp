<%-- 
    Document   : index
    Created on : Oct 14, 2016, 7:11:51 PM
    Author     : student
--%>

<%@page import="service.RegisterService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form method="post">
            <p>Username: <input type="text" name="username" /></p>
            <p>Parola: <input type="password" name="parola" /></p>
            <p><input type="submit" value="Register" /></p>
        </form>
        
        <%
            String username = request.getParameter("username");
            String parola = request.getParameter("parola");
            if(username != null && parola != null){
                boolean rez = RegisterService.getInstance().registerUser(username, parola);
                if(rez){
                    out.println("<h2>Userul a fost adaugat</h2>");
                }else{
                    out.println("<h2>Userul exista deja in baza</h2>");
                }
            }
        %>
    </body>
</html>
