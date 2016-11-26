<%-- 
    Document   : welcome
    Created on : 19-Nov-2016, 13:10:01
    Author     : m2-abdalla
--%>


<%@page import="java.util.Random"%>
<html>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <h1 align="center"> you have registered to XYZ company! </h1>
    <form>
        <body>
            <p><b>Your username is:  </b>
                <% String name = request.getParameter("firstname");
                    char fname = name.charAt(0);

                    String ln = request.getParameter("lastname");
                    char lname = ln.charAt(0);

                    out.println(fname + "" + lname + "-" + ln);
                %>

                <br>
            <p><b>Your password is:</b>
                <% String DOB = request.getParameter("DOB");

                    out.print(DOB);

                    Random rand = new Random();

                    for (int i = 0; i < 4; i++) {
                        int num = rand.nextInt(9) + 1;
                        out.print(num);
                    }
                %>
            </p>
            <br/>
    </form>
</body>
</html>
