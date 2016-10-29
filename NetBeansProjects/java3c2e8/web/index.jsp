<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
        String color = "white";
        if(request.getParameter("color") != null){
            color = request.getParameter("color");
            Cookie cookie = new Cookie("color", color);
            response.addCookie(cookie);
        }else{
            Cookie [] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie c : cookies){
                    if(c.getName().equals("color")){
                        color = c.getValue();
                    }
                }
            }
        }
    %>
    <body style="background-color: <%= color %>;">
        <p><a href="index.jsp?color=red">ROSU</a></p>
        <p><a href="index.jsp?color=green">GREEN</a></p>
        <p><a href="index.jsp?color=blue">BLUE</a></p>
    </body>
</html>
