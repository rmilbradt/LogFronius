package br.ufsm.csi.controller;

import br.ufsm.csi.beans.LeituraInversorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by politecnico on 07/07/2015.
 */
@Controller
public class ChartController {

    @Autowired
    private LeituraInversorDAO dao;

    @RequestMapping("chart-json.html")
    public String dadosChartJSON(Model model) {
        model.addAttribute("leituras", dao.findLeiturasUltimasHoras(2));
        return "chart-json";
    }

}
