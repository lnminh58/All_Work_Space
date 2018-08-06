<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-28
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Login Form</h1>
<%

    HttpSession session1 = request.getSession();

    if (request.getParameter("submit") != null) {
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        String capcha = request.getParameter("capcha").toString();
        String capchaOld = session1.getAttribute("capcha").toString();

        if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")&&capcha.equalsIgnoreCase(capchaOld)){
            out.print("Dang nhap thanh cong");
        }else {
            out.print("Dang nhap that bai");
        }
    }
%>
<form action="" method="post">
    <input type="text" placeholder="username" name="username"/>
    <br>
    <input type="password" placeholder="password" name="password"/>
    <br>
    <%  Random random = new Random();
        String alphabet= "0123456789abcdefghijklmnopqrstuvwxyz";
        String capcha="";
        for (int i= 0;i<5;i++){
            capcha+=alphabet.charAt(random.nextInt(alphabet.length()-1));
        }
        session1.setAttribute("capcha",capcha);
        out.print("capcha: " + capcha);


        %>
    <br>
    <input type="text" placeholder="capcha" name="capcha">
    <br>
    <input type="submit" value="submit" name="submit"/>
</form>
</body>
</html>
