<%@ page import="com.aptech.webent.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="com.aptech.webent.service.StringToListProduct" %><%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 2018-06-29
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Product> products = new ArrayList<>();
        String cookieName = "products";
        Cookie cookies [] = request.getCookies ();
        Cookie cookie;
        if (cookies != null)
        {
            for (int i = 0; i < cookies.length; i++)
            {
                if (cookies [i].getName().equals (cookieName))
                {
                    String decode = URLDecoder.decode(cookies[i].getValue());
                    products = StringToListProduct.convertToListProducts(decode);
                    break;
                }
            }
        }
    %>
    <h3>Giỏ hàng của bạn hiện có</h3>
    <table>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
        </tr>
        <%
            for (Product product: products){
               out.print("<tr><td>"+product.getProductName()+"</td><td>"+product.getQuantity()+"</td><tr>");
            }
        %>
    </table>
</body>
</html>
