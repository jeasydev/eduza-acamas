<!DOCTYPE html>
<%-- 
    Document   : feeds
    Created on : Jan 4, 2018, 10:57:07 PM
    Author     : jeasydev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head><title>Facebook Feed Data</title></head>
<body>
 <h3>Hello, <span th:text="${facebookProfile.name}">Some User</span>!</h3>
 <h4>Here is your home feed:</h4>
 <div th:each="post:${feed}" style="width:400px;">
  <b th:text="${post.from.name}">from</b> wrote:
  <p th:text="${post.message}">message text</p>
  <img th:if="${post.picture}" th:src="${post.picture}" style="width:100px;height:100px;"/>
  <hr/>
 </div>
</body>
</html>