<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link href="${pageContext.request.contextPath}/public/vendors/bootstrap-3.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/public/vendors/bootstrap-3.0.0/dist/css/bootstrap-theme.min.css" rel="stylesheet">
    </head>

    <body>
        <sf:form method="post" modelAttribute="userProfileFromForm">
            <div class="col-sm-6 col-sm-offset-3" style="margin-top: 22px;">
                <div class="panel panel-default" style="width: 300px; ">
                    <div class="panel-heading">
                        สมัครสมาชิก
                    </div>
                    <div class="panel-body">

                        <table>
                            <tr>
                                <td>
                                    <sf:input path="firstName" type="text" style="margin-top: 3px;" class="form-control" placeholder="ชื่อ"/>
                                </td>
                                <td  >
                                    <div style="margin-left: 2px;">
                                        <sf:input  path="lastName" type="text" style="margin-top: 3px;" class="form-control" placeholder="นามสกุล"/>
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <sf:input path="username" type="text" style="margin-top: 3px;" class="form-control" placeholder="อีเมลล์หรือหมายเลขโทรศัพท์มือถือ"/>
                        <sf:input path="password" type="password" style="margin-top: 3px;" class="form-control" placeholder="กำหนดรหัสผ่าน"/>

                        <table>
                            <tr>
                                <td>
                                    <div class="input-group" style="margin-left: 14px;">
                                        <div class="input-group-btn">
                                            <sf:radiobutton path="gender"   class="form-control" value="m" />
                                        </div>
                                        <div style="margin-top:10px; margin-left: 5px;">ชาย</div>
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group" style="margin-left: 14px;">
                                        <div class="input-group-btn">
                                            <sf:radiobutton path="gender"   class="form-control" value="f" />
                                        </div>
                                        <div style="margin-top:10px; margin-left: 5px;">หญิง</div>
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <!--div class="input-group" >
                            <span class="input-group-addon">
                                วันเกิด
                            </span>
                            < sf:input path="birthDate" type="date"  class="form-control" />
                        </div-->
                        <!--sf:input path="username"  type="text"  class="form-control" placeholder="Username"/-->
                        <!--sf:input path="secretCode"  type="password" style="margin-top: 3px;" class="form-control" placeholder="Password Again"/-->
                    </div>

                    <div class="panel-footer">
                        <table>
                            <tr>
                                <td><input class="btn btn-success" type="submit" value="สร้างบัญชีผู้ใช้..."/></td>
                            </tr> 
                        </table>
                    </div>
                    <div class="panel-footer" > 
                        <div>
                            หรือเข้าใช้ผ่าน..
                        </div>
                        <input class="btn btn-primary" type="submit" value="Facebook"/>
                        <input class="btn btn-danger" type="submit" style="margin-top: 3px;" value="Google+"/>
                    </div>
                </div>
            </div>

        </sf:form>
        <script src="${pageContext.request.contextPath}/public/vendors/bootstrap-3.0.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
