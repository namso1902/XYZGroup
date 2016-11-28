<%-- 
    Document   : member_reg
    Created on : 31-Oct-2016, 14:33:07
    Author     : namso1902
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE html>
     <h1 align="center"> Registration Form </h1>      
     <body>
         <form align="center" 
             action ="/Registration" method="POST">
             User id:<br>
             <input type="text" name="userId"  align="center" required><br>
             First name:<br>
             <input type="text" name="firstname"  align="center" required><br>
             Last name:<br>
             <input   type="text" name="lastname" required><br>
             Address:<br>
             <input   type="text" name="address" required><br>
             Date Of Birth:<br>
             <input type="date" name="DOB" required><br><p/>        
             <input type="submit" value="Submit">       
         </form>       
    </body>
 </html>
