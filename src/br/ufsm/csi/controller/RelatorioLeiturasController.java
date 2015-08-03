package br.ufsm.csi.controller;

import br.ufsm.csi.beans.LeituraInversorDAO;
import br.ufsm.csi.model.LeituraInversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String relatorio(@DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicial, @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFinal, Model model) {
        List<LeituraInversor> leituras = dao.findLeiturasByData(dataInicial, dataFinal);
        model.addAttribute("leituras", leituras);
        return "relatorio";
    }

    @RequestMapping("relatorioVisaoGeral.html")
    public String relatorioVisaoGeral(Model model) {
        List<LeituraInversor> leituras = dao.findLeituras();
        model.addAttribute("leituras", leituras);
        return "relatorioVisaoGeral";
    }

    @RequestMapping("relatorioSensores.html")
    public String relatorioSensores(Model model) {
        List<LeituraInversor> leituras = dao.findLeituras();
        model.addAttribute("leituras", leituras);
        return "relatorioSensores";
    }

    @RequestMapping("relatorioOutros.html")
    public String relatorioOutros(Model model) {
        List<LeituraInversor> leituras = dao.findLeituras();
        model.addAttribute("leituras", leituras);
        return "relatorioOutros";
    }

    @RequestMapping("testeCharts.html")
    public String testeCharts(Model model) {
        List<LeituraInversor> leituras = dao.findLeiturasUltimasHoras(2);
        model.addAttribute("leituras", leituras);
        return "testeCharts";
    }

}
