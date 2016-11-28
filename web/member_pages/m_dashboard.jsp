<%-- 
    Document   : m_dashboard
    Created on : 16-Nov-2016, 23:03:12
    Author     : namso1902
--%>

<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard for XYZ Members</title>
    </head>
    <body>
    <Center><h1>Member Dashboard: </h1></Center> <p>
    <h2>Member details: </h2>
    <!--Member account info-->
    <div>
        <% ResultSet member = (ResultSet) request.getAttribute("member");
                String id = member.getString("id");
                application.setAttribute("member_Id", id);
                String name = member.getString("name");
                String address = member.getString("address");
                Date dob = member.getDate("dob");
                out.print("Account Information");
                out.print("Name: " + name);
                out.print("Address: " + address);
                out.print("DOB: " + dob.toString());
            %>
    </div>
    <!--Submit claim-->
    <div>
        
    </div>
    <!--List all claims-->       
    <form method= action="/GetClaims">
        <intput name="getMemberClaims"/>
    </form>
    <%  ResultSet claims = (ResultSet) request.getAttribute("claims");
          String userId = application.getAttribute("member_Id").toString();
          ResultSet rs_claims = (ResultSet) request.getAttribute("claims");
          while (rs_claims.next()) {
              out.print("Claim id: " + rs_claims.getInt("id") +
                         "<br/>Date: " + rs_claims.getInt("id") +
                         "<br/>Rationale:" + rs_claims.getString("date")
                                 .toString() +
              rs_claims.getInt("id");
              rs_claims.getString("date").toString();
              rs_claims.getString("rationale").toString();
              rs_claims.getString("status").toString();
              rs_claims.getFloat("amount")
          }
        %>
    </body>
</html>
