<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[
<c:forEach items="${leituras}" var="leitura" varStatus="st">
  [[<fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="HH', 'mm', 'ss"/>], ${leitura.potencia}]
  <c:if test="${not st.last}">, </c:if>
</c:forEach>
]
