package br.ufsm.csi.controller;

import br.ufsm.csi.beans.LeituraInversorDAO;
import br.ufsm.csi.model.Inversor;
import br.ufsm.csi.model.LeituraInversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by politecnico on 19/06/2015.
 */
@Controller
public class RelatorioLeiturasController {

    @Autowired
    private LeituraInversorDAO dao;

    @RequestMapping("relatorio.html")
    public String relatorio(@DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal, Model model) {
        List<LeituraInversor> leituras = dao.findLeiturasByData(dataInicial, dataFinal);
        model.addAttribute("leituras", leituras);
        return "relatorio";
    }

    @RequestMapping("relatorio.json")
    public String relatorioCSV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal, HttpServletResponse response) throws IOException {
        OutputStream out = response.getOutputStream();
        List<LeituraInversor> leituras = dao.findLeiturasByData(dataInicial, dataFinal);
        out.write("Data;".getBytes());
        out.write("Potência (W);".getBytes());
        out.write("Dia (Wh);".getBytes());
        out.write("Ano (KWh);".getBytes());
        out.write("Total (KWh);".getBytes());
        out.write("Temp. Módulos (ºC);".getBytes());
        out.write("Temp. Ambiente(ºC);".getBytes());
        out.write("Irradiância (W/m²);".getBytes());
        out.write("Vento (m/s);".getBytes());
        out.write("Frequência CA (Hz);".getBytes());
        out.write("Corrente CA (A);".getBytes());
        out.write("Corrente CC (A);".getBytes());
        out.write("Tensão CA (A);".getBytes());
        out.write("Tensão CC (A);".getBytes());
        out.write("\n".getBytes());
        for (LeituraInversor leituraInversor : leituras) {
            out.write(leituraInversor.getDataHoraLeitura().toString().getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getPotencia()).getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getEnergiaDia()).getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getEnergiaAnual()).getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getEnergiaTotal()).getBytes());
            out.write(";".getBytes());
            out.write(Integer.toString(leituraInversor.getTempModulos()).getBytes());
            out.write(";".getBytes());
            if (leituraInversor.getTempAmbiente() != null) {
                out.write(leituraInversor.getTempAmbiente().toString().getBytes());
            }
            out.write(";".getBytes());
            out.write(leituraInversor.getIrradiancia().toString().getBytes());
            out.write(";".getBytes());
            out.write(leituraInversor.getVento().toString().getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getAcFrequency()).getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getAcCurrent()).getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getDcCurrent()).getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getAcVoltage()).getBytes());
            out.write(";".getBytes());
            out.write(Double.toString(leituraInversor.getDcVoltage()).getBytes());
            out.write(";".getBytes());
            out.write("\n".getBytes());
        }
        return null;
    }

    @RequestMapping("relatorioVisaoGeral.html")
    public String relatorioVisaoGeral(@DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal, Model model) {
        List<LeituraInversor> leituras = dao.findLeiturasByData(dataInicial, dataFinal);
        model.addAttribute("leituras", leituras);
        return "relatorioVisaoGeral";
    }

    @RequestMapping("relatorioSensores.html")
    public String relatorioSensores(@DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal, Model model) {
        List<LeituraInversor> leituras = dao.findLeiturasByData(dataInicial, dataFinal);
        model.addAttribute("leituras", leituras);
        return "relatorioSensores";
    }

    @RequestMapping("relatorioOutros.html")
    public String relatorioOutros(@DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal, Model model) {
        List<LeituraInversor> leituras = dao.findLeiturasByData(dataInicial, dataFinal);
        model.addAttribute("leituras", leituras);
        return "relatorioOutros";
    }

    @RequestMapping("testeCharts.html")
    public String testeCharts(Model model) {
        List<LeituraInversor> leituras = dao.findLeiturasUltimasHoras(2);
        model.addAttribute("leituras", leituras);
        return "testeCharts";
    }

    @RequestMapping("cadastra-inversor.html")
    public String cadastra(Inversor inversor) {

        return "cadastra-inversor";
    }

}
