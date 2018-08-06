<%@ page import="java.util.List" %>
<%@ page import="com.aptech.webent.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.aptech.webent.service.ListProductsToString" %>
<%@ page import="com.aptech.webent.service.StringToListProduct" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 2018-06-29
  Time: 7:29 PM
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

    if (request.getParameter("submit") != null) {
        String[] strProducts = request.getParameterValues("product");
        for (String strProduct : strProducts) {
            if (products.size() == 0) {
                products.add(new Product(strProduct, 1));
            }else {
                boolean hasProduct = false;
                for (Product product : products) {
                    if (product.getProductName().equalsIgnoreCase(strProduct)) {
                        product.setQuantity(product.getQuantity() + 1);
                        hasProduct=true;
                        break;
                    }
                }
                if(!hasProduct){
                        products.add(new Product(strProduct, 1));
                }
            }
        }

    }
        cookie = new Cookie("products",URLEncoder.encode( ListProductsToString.convertToString(products), "UTF-8" ));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
%>

<h2>Vui lòng chọn sản phẩm</h2>
<form action="" method="POST">
    <ul>
        <li><input type="checkbox" name="product" value="Xiaomi Mi8">Xiaomi Mi8</li>
        <li><input type="checkbox" name="product" value="Xiaomi Redmi Note 5 Plus">Xiaomi Redmi Note 5 plus</li>
        <li><input type="checkbox" name="product" value="Xiaomi Redmi 6">Xiaomi Redmi 6</li>
    </ul>
    <input type="submit" value="Buy" name="submit">
</form>

<h4>Bạn đang có <% out.print(products.size()); %> sản phẩm trong giỏ hàng</h4><br>
<a href="cart.jsp">Đi tới giỏ hàng</a>
</body>
</html>
