<%-- 
    Document   : Registeration
    Created on : 19-Nov-2016
    Author     : m2-abdalla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <h1 align="center"> Registration Form </h1>
      
    <body>

        <form align="center" 
            action ="welcome.jsp" method="POST">

            First name:<br>
            <input type="text" name="firstname"  align="center" required><br>
            Last name:<br>
            <input   type="text" name="lastname" required><br>
            Address:<br>
            <input   type="text" name="Address" required><br>
            Date Of Birth:<br>
            <input type="date" name="DOB" required><br>
            Date of Registration:<br>
            <input type="date" name="date of registration" required><br>
                
         
            <input type="submit" value="Submit">
            
         
            
            
        </form>

        
    </body>
</html>
