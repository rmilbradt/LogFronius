<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: politecnico
  Date: 19/06/2015
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Relatório</title>
</head>
<body>
  <table>
    <tr>
      <th>Data</th>
      <th>Potência</th>
      <th>Vento</th>
    </tr>
    <c:forEach items="${leituras}" var="leitura">
      <tr>
        <td><fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
        <td>${leitura.potencia}</td>
        <td>${leitura.vento}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
