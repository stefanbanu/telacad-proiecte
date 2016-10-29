<%@page import="service.LoginService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String username = request.getParameter("username");
            String parola = request.getParameter("parola");
            
            boolean logged = false;
            if(username != null && parola != null){
             logged = LoginService.getInstance().login(username, parola);
             session.setAttribute("logged", String.valueOf(logged));
            }else{
                if(session.getAttribute("logged") != null){
                    logged = session.getAttribute("logged").toString().equals("true");
                }
            }
            
            if(request.getParameter("logout") != null){
                session.setAttribute("logged", null);
                response.sendRedirect("index.jsp");
            }
            
            
            if(logged){
        %>
           <jsp:include page="pagini/main.jsp" />
        <% } else { %>
           <jsp:include page="pagini/formular.jsp" />
        <% } %>
    </body>
</html>
