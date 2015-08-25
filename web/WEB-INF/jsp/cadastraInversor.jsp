<%--
  Created by IntelliJ IDEA.
  User: 201420240
  Date: 21/08/2015
  Time: 10:00
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


  <div class="row">
    <div class="col-md-4 column col-lg-offset-4">

      <form role="form" action="" method="post">
        <legend style="text-align: center"><b>Cadastro de Inversor</b></legend>
        <div class="form-group">
          <label for="nome">Nome:</label>
          <input type="text" class="form-control" placeholder="nome" id="nome" name="nome">
        </div>
        <div class="form-group">
          <label for="localizacao">Localização:</label>
          <input type="text" class="form-control" placeholder="localização" id="localizacao" name="localizacao">
        </div>
        <div class="form-group">
          <label for="coordenadas">Coordenadas:</label>
          <input type="text" class="form-control" placeholder="coordenadas" id="coordenadas" name="coordenadas">
        </div>
        <div class="form-group">
          <label for="ip">Ip:</label>
          <input type="text" class="form-control" placeholder="ip" id="ip" name="ip">
        </div>
        <button type="submit" class="btn btn-primary center-block" name="acao" value="Cadastrar">Cadastrar</button>
      </form>

    </div>
  </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
