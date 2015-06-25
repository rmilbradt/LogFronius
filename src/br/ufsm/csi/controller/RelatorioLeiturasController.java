package br.ufsm.csi.controller;

import br.ufsm.csi.beans.LeituraInversorDAO;
import br.ufsm.csi.model.LeituraInversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by politecnico on 19/06/2015.
 */
@Controller
public class RelatorioLeiturasController {

    @Autowired
    private LeituraInversorDAO dao;

    @RequestMapping("relatorio.html")
    public String relatorio(Model model) {
        List<LeituraInversor> leituras = dao.findLeituras();
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

}
