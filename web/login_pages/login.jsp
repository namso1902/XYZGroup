<%-- 
    Document   : member_login
    Created on : 31-Oct-2016, 14:31:48
    Author     : namso1902
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member login</title>
    </head>
        <form method="POST" action="MemberLogin.do">
             User name:<br>
             <input type="text" name="username"><br>
             User password:<br>
             <input type="password" name="psw">
             <input type="submit">
         </form><br/>
    <a href="member_reg.jsp">Not a registered Member? Click here.</a>
    </body>
</html>
