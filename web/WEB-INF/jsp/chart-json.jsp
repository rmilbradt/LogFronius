<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

{
  "cols": [
    {"id": "", "label": "Data", "type": "timeofday"},
    {"id": "", "label":
                <c:choose>
                    <c:when test="${param.variavel == 'potencia'}">"Potência"</c:when>
                    <c:when test="${param.variavel == 'energiaDia'}">"Dia"</c:when>
                    <c:when test="${param.variavel == 'energiaAnual'}">"Anual"</c:when>
                    <c:when test="${param.variavel == 'energiaTotal'}">"Total"</c:when>
                    <c:when test="${param.variavel == 'tempModulos'}">"Temperatura Módulos"</c:when>
                    <c:when test="${param.variavel == 'tempAmbiente'}">"Temperatura Ambiente"</c:when>
                    <c:when test="${param.variavel == 'irradiancia'}">"Irradiancia"</c:when>
                    <c:when test="${param.variavel == 'vento'}">"Vento"</c:when>
                    <c:when test="${param.variavel == 'acFrequency'}">"Frequência CA"</c:when>
                    <c:when test="${param.variavel == 'acCurrent'}">"Corrente CA"</c:when>
                    <c:when test="${param.variavel == 'dcCurrent'}">"Corrente CC"</c:when>
                    <c:when test="${param.variavel == 'acVoltage'}">"Tensão CA"</c:when>
                    <c:when test="${param.variavel == 'dcVoltage'}">"Tensão CC"</c:when>
                </c:choose>,
                "type": "number"}
    ],

  "rows": [
<c:forEach items="${leituras}" var="leitura" varStatus="st">
    {"c": [
        {"v": [<fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="HH', 'mm', 'ss"/>]},
        {"v":
        <c:choose>
            <c:when test="${param.variavel == 'potencia'}">${leitura.potencia}</c:when>
            <c:when test="${param.variavel == 'energiaDia'}">${leitura.energiaDia}</c:when>
            <c:when test="${param.variavel == 'energiaAnual'}">${leitura.energiaAnual}</c:when>
            <c:when test="${param.variavel == 'energiaTotal'}">${leitura.energiaTotal}</c:when>
            <c:when test="${param.variavel == 'tempModulos'}">${leitura.tempModulos}</c:when>
            <c:when test="${param.variavel == 'tempAmbiente'}">${leitura.tempAmbiente}</c:when>
            <c:when test="${param.variavel == 'irradiancia'}">${leitura.irradiancia}</c:when>
            <c:when test="${param.variavel == 'vento'}">${leitura.vento}</c:when>
            <c:when test="${param.variavel == 'acFrequency'}">${leitura.acFrequency}</c:when>
            <c:when test="${param.variavel == 'acCurrent'}">${leitura.acCurrent}</c:when>
            <c:when test="${param.variavel == 'dcCurrent'}">${leitura.dcCurrent}</c:when>
            <c:when test="${param.variavel == 'acVoltage'}">${leitura.acVoltage}</c:when>
            <c:when test="${param.variavel == 'dcVoltage'}">${leitura.dcVoltage}</c:when>
        </c:choose>
    }]}
        <c:if test="${not st.last}">, </c:if>
</c:forEach>
  ]
}