<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-07
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <% String lang= null, country = null;
    Locale locale = null;
    ResourceBundle resourceBundle = null;
    lang= request.getParameter("language");
    if(lang == null || lang.equals("English")){
      lang="en";
      country="US";
      locale = new Locale(lang,country);
      resourceBundle = ResourceBundle.getBundle("mypackage/global_en_US.properties",locale);
    }else if (lang.equals("Hindi")){
      lang="hi";
      country="IN";
      locale = new Locale(lang,country);
      resourceBundle = ResourceBundle.getBundle("mypackage/global_hi_IN.properties",locale);
    }
    String str = resourceBundle.getString("text1");
  %>
  <%=str%>
  <form action="index.jsp" method="post">
    please select a language: <br/>
    <input type="radio" name="language" value="English"> English
    <input type="radio" name="language" value="Hindi"> Hindi <br/>
    <input type="submit" value="ChangeLanguage">
  </form>
  </body>
</html>
