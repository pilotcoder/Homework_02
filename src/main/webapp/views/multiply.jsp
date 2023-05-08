<jsp:useBean id="value" scope="request" type="java.lang.Integer"/>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 07.05.2023
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
size= ${value}
<br>


<%
    int size = value;
    for (int i = 1; i <= size; i++) {
%>
<%= i %>
<%
    for (int j = 2; j <= size; j++) {
%>
<%= i * j %>

<%
        }
    %>
    <br>
    <%
    }
%>

</body>
</html>
