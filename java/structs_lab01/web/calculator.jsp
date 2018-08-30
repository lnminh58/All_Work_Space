<%-- 
    Document   : calculator
    Created on : Aug 23, 2018, 6:23:48 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <h1>Calculator</h1>
        <hr>
        <html:form action="Calc" method="post">
            Number 1: <html:text property="number1"/>
            <br>
            Number 2: <html:text property="number2"/>
            <br>
            <html:submit value="Add" property="action"/>
            <html:submit value="Subtract" property="action"/>
            <hr>
            <h3>
                Result is <bean:write name="CalculatorForm" property="result"/>
            </h3>
        </html:form>
    </body>
</html>
