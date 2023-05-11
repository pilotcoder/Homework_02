<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 2023-05-10
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/cart/addform">
    Nazwa Produktu    : <input type="text" name="name"> </br>
    Cena    : <input type="number" name="price" step="0.01"> </br>
    Ilość     : <input type="number" name="quantity"> </br>


    <input type="submit" value="Wyślij">
</form>



<h1>Koszyk</h1>
<c:forEach var="item" items="${cartItems}">
    <h1>Ilość: ${item.quantity} | ${item.product.name} w cenie ${item.product.price}
        <input type="button" onclick="location.href='/cart/clearProduct?name=${item.product.name}';" value="Usuń wszystko" />
        <input type="button" onclick="location.href='/cart/addProduct?name=${item.product.name}';" value="zwiększ ilość" />
        <input type="button" onclick="location.href='/cart/deleteProduct?name=${item.product.name}';" value="zmniejsz ilość" /></h1>
</c:forEach>
</body>
</html>