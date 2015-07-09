<%--
  Created by IntelliJ IDEA.
  User: politecnico
  Date: 10/06/2015
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>


<html>
  <head>

    <title>Leitura Fronius</title>

      <script type="text/javascript" src="https://www.google.com/jsapi"></script>

    <script type="text/javascript">
      var chart;
      var options;
      var carregou = false;
      var nomeVariavel = "potencia";

      google.load('visualization', '1.1', {packages: ['line']});
      google.setOnLoadCallback(drawChart);

      function drawChart() {
        chart = new google.charts.Line(document.getElementById('linechart_material'));
        options = {
          chart: {
            title: 'Potência',
            subtitle: 'Ultimas duas hora'
          },
          width: 1000,
          height: 500
        };
        carregou = true;
      }

      function trocaGrafico(variavel) {
        nomeVariavel = variavel;
        if (carregou) {
          var jsonData = $.ajax({
            url: "chart-json.html?variavel=" + nomeVariavel,
            dataType:"json",
            async: false
          }).responseText;

          var data = new google.visualization.DataTable(jsonData);
          chart.draw(data, options);
        }
      }


      setInterval(function(){
        document.getElementById('carreg').style.display = 'block';
        $.ajax({
          url: "leitura-json.html",
          context: document.body,
          success: function(result) {
            var leitura = JSON.parse(result);
            $(data).html(leitura.dataHoraLeitura);
            $(potencia).html(leitura.potencia);
            $(energiaDia).html(leitura.energiaDia);
            $(energiaAnual).html(leitura.energiaAnual);
            $(energiaTotal).html(leitura.energiaTotal);
            $(tempModulos).html(leitura.tempModulos);
            $(tempAmbiente).html(leitura.tempAmbiente);
            $(irradiancia).html(leitura.irradiancia);
            $(vento).html(leitura.vento);
            $(acFrequency).html(leitura.acFrequency);
            $(acCurrent).html(leitura.acCurrent);
            $(dcCurrent).html(leitura.dcCurrent);
            $(acVoltage).html(leitura.acVoltage);
            $(dcVoltage).html(leitura.dcVoltage);


            if (carregou) {
              var jsonData = $.ajax({
                url: "chart-json.html?variavel=" + nomeVariavel,
                dataType:"json",
                async: false
              }).responseText;

              var data = new google.visualization.DataTable(jsonData);
              chart.draw(data, options);
            }

          }
        }).done(function() {
          document.getElementById('carreg').style.display = 'none';
        });
      }, 10000);
    </script>
</head>

<body>

  <div class="container">


    <div align="center" style="display: none" id="carreg"><img src="imagens/carregando.gif"/></div>
      <div class="row">
        <div class="col-md-12 column" style="margin-top: 50px;">

        <div class="row">
          <div class="col-lg-4 column">
            <h2>Visão Geral do Sistema</h2>
              <h3><b>Potência:</b> <span id="potencia"><fmt:formatNumber value="${leitura.potencia}" pattern="#,##0"/> W</span> <button name="troca" onclick="trocaGrafico('potencia');" value="troca"/></h3>
              <h3><b>Dia:</b> <span id="energiaDia"><fmt:formatNumber value="${leitura.energiaDia}" pattern="#,##0.00"/> Wh</span></h3>
              <h3><b>Ano:</b> <span id="energiaAnual"><fmt:formatNumber value="${leitura.energiaAnual}" pattern="#,###,##0.00"/> KWh</span></h3>
              <h3><b>Total:</b> <span id="energiaTotal"><fmt:formatNumber value="${leitura.energiaTotal}" pattern="#,###,##0.00"/> KWh</span></h3>
          </div>
          <div class="col-lg-4 column" style="border-left: 1px solid #777;">
              <h2>Sensores</h2>
              <h3><b>Temperatura módulos:</b> <span id="tempModulos">${leitura.tempModulos} ºC</span></h3>
              <h3><b>Temperatura ambiente:</b> <span id="tempAmbiente">${leitura.tempAmbiente} ºC</span></h3>
              <h3><b>Irradiância:</b> <span id="irradiancia">${leitura.irradiancia} W/m²</span></h3>
              <h3><b>Vento:</b> <span id="vento">${leitura.vento} m/s</span></h3><br /><br />
          </div>
          <div class="col-lg-4 column" style="border-left: 1px solid #777">
            <h2>Outros</h2>
              <h3><b>Frequência CA:</b> <span id="acFrequency"><fmt:formatNumber value="${leitura.acFrequency}" pattern="#,###0.00"/> Hz</span></h3>
              <h3><b>Corrente CA:</b> <span id="acCurrent"><fmt:formatNumber value="${leitura.acCurrent}" pattern="#,##0.00"/> A</span></h3>
              <h3><b>Corrente CC:</b> <span id="dcCurrent"><fmt:formatNumber value="${leitura.dcCurrent}" pattern="#,##0.00"/> A</span></h3>
              <h3><b>Tensão CA:</b> <span id="acVoltage"><fmt:formatNumber value="${leitura.acVoltage}" pattern="#,##0.00"/> V</span> <button name="troca" onclick="trocaGrafico('acVoltage');" value="troca"/> </h3>
              <h3><b>Tensão CC:</b> <span id="dcVoltage"><fmt:formatNumber value="${leitura.dcVoltage}" pattern="#,##0.00"/> V</span></h3>
          </div>

        </div>
      </div>
    </div>

  <h4 style="text-align: right; padding-top: 50px;"><b>Acesso em <span id="data"><fmt:formatDate value="${leitura.dataHoraLeitura}" pattern="dd 'de' MMMMMMMMMMM 'de' yyyy 'às' HH:mm:ss" /></span></b></h4>

    <div class="row">
      <div class="col-md-12 column">
        <div id="linechart_material"></div>
      </div>
    </div>

  </div>

</body>

</html>