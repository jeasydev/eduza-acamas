<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <sf:form method="post" modelAttribute="userProfile">

            <table style="margin-left: 30px">
                <tr><td><u>ชื่อผู้ใช้</u>ของท่าน: </td><td><sf:errors path="username" cssClass="error" /><br /><sf:input path="username"  type="text" /></td></tr>
                <tr><td>กำหนด<u>รหัสผ่าน</u>: </td><td><sf:errors path="password" cssClass="error" /><br /><sf:input path="password" type="password" /></td></tr>
                <tr><td>ยืนยันรหัสผ่าน: </td><td><sf:errors path="secretCode" cssClass="error" /><br /><sf:input path="secretCode"  type="password" /></td></tr>
                <tr><td>ชื่อ: </td><td><sf:errors path="firstName" cssClass="error" /><br /><sf:input path="firstName" type="text" /></td></tr>
                <tr><td>นามสกุล: </td><td><sf:errors path="lastName" cssClass="error" /><br /><sf:input path="lastName" type="text" /></td></tr>
                <tr><td>อีเมลล์: </td><td><sf:errors path="email" cssClass="error" /><br /><sf:input path="email" type="text" /></td></tr>
            </table>
            <input type="submit" value="ฉันยอมรับเงื่อนไขการใช้งาน... สร้างระเบียนผู้ใช้งานของฉัน"/>
        </sf:form>
    </body>
</html>
