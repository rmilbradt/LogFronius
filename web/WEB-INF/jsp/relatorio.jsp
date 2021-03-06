<%--
  Created by IntelliJ IDEA.
  User: politecnico
  Date: 19/06/2015
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Relatório</title>

  <link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="all">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" media="all"/>


</head>
<body>

<div class="container">

  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="leitura.html" style="font-size: 27px;"><b>Inversor Fronius Politécnico</b></a>
      </div>
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 16px;">Inversores<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="listaInversores.html">Inversores Cadastrados</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="cadastraInversor.html">Cadastrar novo Inversor</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 16px;">Relatórios<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="relatorio.html">Relatório</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="relatorioVisaoGeral.html">Visão Geral do Sistema</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="relatorioSensores.html">Sensores</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="relatorioOutros.html">Outros</a></li>
            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>

  <h2 style="margin-bottom: 20px; text-align: center">Relatório</h2>

  <form style="margin-bottom: 30px; text-align: center" class="form-inline" role="form" action="relatorio.html" method="get">
    <div class="form-group">
      <label for="dataInicial">De</label>
      <input type="date" class="form-control" id="dataInicial" name="dataInicial" value="${param.dataInicial}">
    </div>
    <div class="form-group">
      <label for="dataFinal">até</label>
      <input type="date" class="form-control" id="dataFinal" name="dataFinal" value="${param.dataFinal}">
    </div>
    <button type="submit" class="btn btn-primary">Filtrar</button>
    <a href="relatorio.json?dataInicial=${param.dataInicial}&dataFinal=${param.dataFinal}" class="btn btn-success" download="Fronius de ${param.dataInicial} a ${param.dataFinal}.csv">Exportar CSV</a>
  </form>

  <div class="row">

    <table class="table table-bordered table-striped">
      <tr>
        <th>Data</th>
        <th>Potência (W)</th>
        <th>Dia (Wh)</th>
        <th>Ano (KWh)</th>
        <th>Total (KWh)</th>
        <th>Temp. Módulos (ºC)</th>
        <th>Temp. Ambiente(ºC)</th>
        <th>Irradiância (W/m²)</th>
        <th>Vento (m/s)</th>
        <th>Frequência CA (Hz)</th>
        <th>Corrente CA (A)</th>
        <th>Corrente CC (A)</th>
        <th>Tensão CA (A)</th>
        <th>Tensão CC (A)</th>
      </tr>
      <c:forEach items="${leituras}" var="leitura">
        <tr>
          <td><fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
          <td><fmt:formatNumber value="${leitura.potencia}" pattern="#,##0.00"/></td>
          <td><fmt:formatNumber value="${leitura.energiaDia}" pattern="#,##0.00"/></td>
          <td><fmt:formatNumber value="${leitura.energiaAnual}" pattern="#,###,##0.00"/></td>
          <td><fmt:formatNumber value="${leitura.energiaTotal}" pattern="#,###,##0.00"/></td>
          <td>${leitura.tempModulos}</td>
          <td>${leitura.tempAmbiente}</td>
          <td>${leitura.irradiancia}</td>
          <td>${leitura.vento}</td>
          <td><fmt:formatNumber value="${leitura.acFrequency}" pattern="#,###0.00"/></td>
          <td><fmt:formatNumber value="${leitura.acCurrent}" pattern="#,##0.00"/></td>
          <td><fmt:formatNumber value="${leitura.dcCurrent}" pattern="#,##0.00"/></td>
          <td><fmt:formatNumber value="${leitura.acVoltage}" pattern="#,##0.00"/></td>
          <td><fmt:formatNumber value="${leitura.dcVoltage}" pattern="#,##0.00"/></td>

        </tr>
      </c:forEach>
    </table>
  </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
