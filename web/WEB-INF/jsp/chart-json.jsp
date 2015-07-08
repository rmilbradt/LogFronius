<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

{
  "cols": [
    {"id": "", "label": "Data", "type": "timeofday"},
    {"id": "", "label": "Potência", "type": "number"}
  ],
  "rows": [
<c:forEach items="${leituras}" var="leitura" varStatus="st">
    {"c": [{"v": [<fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="HH', 'mm', 'ss"/>]},
    {"v":
    <c:choose>
        <c:when test="${param.variavel == 'potencia'}">
            ${leitura.potencia}
        </c:when>
        <c:when test="${param.variavel == 'tensaoCA'}">
            ${leitura.acVoltage}
        </c:when>
    </c:choose>
    }]}
    <c:if test="${not st.last}">, </c:if>
</c:forEach>
  ]
}