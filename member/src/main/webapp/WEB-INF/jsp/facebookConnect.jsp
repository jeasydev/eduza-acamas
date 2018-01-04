<!DOCTYPE html>
<%-- 
    Document   : facebookConnect
    Created on : Jan 4, 2018, 10:55:52 PM
    Author     : jeasydev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head><title>Connect to Facebook</title></head>
    <body>
        <h3>Connect to Facebook</h3>
        <form action="${pageContext.request.contextPath}/fb/auth" method="POST">
            <input type="hidden" name="scope" value="read_stream" />
            <div><p>You aren't connected to Facebook yet.</p></div>
            <p><button type="submit">Login With Facebook</button></p>
            <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
        </form>
    </body>
</html>
