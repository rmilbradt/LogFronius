<%--
  Created by IntelliJ IDEA.
  User: politecnico
  Date: 10/06/2015
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Leitura Fronius</title>

      <link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="all">
      <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" media="all"/>


  </head>
  <body>

  <div class="container">

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header" style="padding: 3px;">
          <a class="navbar-brand" href="#" style="font-size: 22px; color: white;"><b>Inversor Fronius Politécnico</b></a>
        </div>
      </div>
    </nav>


    <div class="row">
      <div class="col-md-12 column" style="margin-top: 120px;">

        <div class="row">
          <div class="col-lg-4 column">
            <h2 style="text-decoration: underline; font-weight: bold;">Visão Geral do Sistema</h2>
              <h3><b>Potência:</b> <fmt:formatNumber value="${leitura.potencia}" pattern="#,##0.00"/> W</h3>
              <h3><b>Dia:</b> <fmt:formatNumber value="${leitura.energiaDia}" pattern="#,##0.00"/> Wh</h3>
              <h3><b>Ano:</b> <fmt:formatNumber value="${leitura.energiaAnual}" pattern="#,##0.00"/> KWh</h3>
              <h3><b>Total:</b> <fmt:formatNumber value="${leitura.energiaTotal}" pattern="#,##0.00"/> KWh</h3>
          </div>
          <div class="col-lg-4 column" style="border-left: 1px solid slategray;">
              <h2  style="text-decoration: underline; font-weight: bold;">Sensores</h2>
              <h3><b>Temperatura módulos:</b> ${leitura.tempModulos} ºC</h3>
              <h3><b>Temperatura ambiente:</b> ${leitura.temAmbiente} ºC</h3>
              <h3><b>Irradiância:</b> ${leitura.irradiancia} W/m²</h3>
              <h3><b>Vento:</b> ${leitura.vento} m/s</h3><br /><br />
          </div>
          <div class="col-lg-4 column" style="border-left: 1px solid slategray">
            <h2  style="text-decoration: underline; font-weight: bold;">Outros</h2>
              <h3><b>Frequência CA:</b> <fmt:formatNumber value="${leitura.acFrequency}" pattern="#,###0.00"/> Hz</h3>
              <h3><b>Corrente CA:</b> <fmt:formatNumber value="${leitura.acCurrent}" pattern="#,##0.00"/> A</h3>
              <h3><b>Corrente CC:</b> <fmt:formatNumber value="${leitura.dcCurrent}" pattern="#,##0.00"/> A</h3>
              <h3><b>Tensão CA:</b> <fmt:formatNumber value="${leitura.acVoltage}" pattern="#,##0.00"/> V</h3>
              <h3><b>Tensão CC:</b> <fmt:formatNumber value="${leitura.dcVoltage}" pattern="#,##0.00"/> V</h3>
          </div>

        </div>
      </div>
    </div>

    <h4 style="text-align: right; padding-top: 50px;"><b>Acesso em <fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="dd 'de' MMMMMMMMMMM 'de' yyyy 'às' HH:mm:ss" /></b></h4>

  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>

  </body>
</html>