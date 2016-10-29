<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LAYOUT</h1>
        
        <p><a href="index.jsp?p=1">PAGINA 1</a></p>
        <p><a href="index.jsp?p=2">PAGINA 2</a></p>
        <p><a href="index.jsp?p=3">PAGINA 3</a></p>
        
        <c:if test="${param['p'] == '1'}">
            <jsp:include page="pagini/unu.jsp" />
        </c:if>
        
        <c:if test="${param['p'] == '2'}">
            <jsp:include page="pagini/doi.jsp" />
        </c:if>
        
        <c:if test="${param['p'] == '3'}">
            <jsp:include page="pagini/trei.jsp" />
        </c:if>
        
    </body>
</html>
