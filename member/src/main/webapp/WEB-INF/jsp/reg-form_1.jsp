<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form method="post" action="r">
            <table>
                <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
                <tr><td>username: </td><td><input name="txt_user" id="txt_user" type="text" /></td></tr>
                <tr><td>password: </td><td><input name="txt_pw" id="txt_pw" type="password" /></td></tr>
                <tr><td>confirm password: </td><td><input name="txt_pwc" id="txt_pwc" type="password" /></td></tr>
                <tr><td>firstname: </td><td><input name="txt_firstname" id="txt_firstname" type="text" /></td></tr>
                <tr><td>lastname: </td><td><input name="txt_lastname" id="txt_lastname" type="text" /></td></tr>
                <tr><td>email: </td><td><input name="txt_email" id="txt_email" type="text" /></td></tr>
                <tr><td><button >login via facebook</button> </td><td><input type="submit" value="Submit" /></td></tr>



            </table>

        </form>
    </body>
</html>
