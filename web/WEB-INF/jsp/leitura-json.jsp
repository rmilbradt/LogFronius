<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
{
  "id" : "${leitura.id}",
  "dataHoraLeitura" : "<fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="dd 'de' MMMMMMMMMMM 'de' yyyy 'às' HH:mm:ss" />",
  "potencia" : "<fmt:formatNumber value="${leitura.potencia}" pattern="#,##0.00"/> W",
  "energiaDia" : "<fmt:formatNumber value="${leitura.energiaDia}" pattern="#,##0.00"/> Wh",
  "energiaAnual" : "<fmt:formatNumber value="${leitura.energiaAnual}" pattern="#,##0.00"/> KWh",
  "energiaTotal" : "<fmt:formatNumber value="${leitura.energiaTotal}" pattern="#,##0.00"/> KWh",
  "tempModulos" : "${leitura.tempModulos} ºC",
  "temAmbiente" : "${leitura.temAmbiente} ºC",
  "irradiancia" : "${leitura.irradiancia} W/m²",
  "vento" : "${leitura.vento} m/s",
  "acFrequency" : "<fmt:formatNumber value="${leitura.acFrequency}" pattern="#,###0.00"/> Hz",
  "acCurrent" : "<fmt:formatNumber value="${leitura.acCurrent}" pattern="#,##0.00"/> A",
  "dcCurrent" : "<fmt:formatNumber value="${leitura.dcCurrent}" pattern="#,##0.00"/> A",
  "acVoltage" : "<fmt:formatNumber value="${leitura.acVoltage}" pattern="#,##0.00"/> V",
  "dcVoltage" : "<fmt:formatNumber value="${leitura.dcVoltage}" pattern="#,##0.00"/> V",
}
