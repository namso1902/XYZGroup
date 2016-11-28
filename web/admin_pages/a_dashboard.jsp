<%-- 
    Document   : a_dashboard
    Created on : 16-Nov-2016, 23:02:41
    Author     : namso1902
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin dashboard</title>
    </head>
    <body>
        <h1 align="Center">Admin Dashboard</h1>
        <!--Admin options-->
        <div>Admin Menu</div>
        <form method="GET" action="ChargeMember">
            <input name="Charge a member" type="submit"/>
        </form>
        <form method="GET" action="GetAllMembers">
            <input name="List all members" type="submit"/>
        </form>
        <form method="GET" action="GetAllClaims">
            <input name="List all claims" type="submit"/>
        </form>
        <form method="GET" action="GetTotalIncome">
            <input name="Show total income" type="submit"/>
        </form>
        <form method="GET" action="GetTotalPayouts">
            <input name="Show total payouts" type="submit"/>
        </form>
    </body>
</html>
