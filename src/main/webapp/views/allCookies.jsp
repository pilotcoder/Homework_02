<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 2023-05-09
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CIASTECZKA</title>
</head>
<body>

<table>
    <c:forEach items="${cookieList}" var="c">
        <tr>
            <td> Nazwa Ciateczka: ${c.name}, Wartość : ${c.value},  </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
