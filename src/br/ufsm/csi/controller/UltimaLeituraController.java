package br.ufsm.csi.controller;

import br.ufsm.csi.beans.LeituraInversorDAO;
import br.ufsm.csi.beans.LeituraUrls;
import br.ufsm.csi.model.LeituraInversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by politecnico on 10/06/2015.
 */
@Controller
public class UltimaLeituraController {

    @Autowired
    private LeituraUrls leituraUrls;

    @Autowired
    private LeituraInversorDAO dao;

    @RequestMapping(value = "leitura.html")
    public String leitura(Model model) throws IOException {
        LeituraInversor l = leituraUrls.getUltimaLeitura();
        model.addAttribute("leitura", l);
        return "leitura";
    }

    @RequestMapping(value = "leitura-json.html")
    public String leituraJSon(Model model) throws IOException {
        LeituraInversor l = leituraUrls.getUltimaLeitura();
        model.addAttribute("leitura", l);
        return "leitura-json";
    }


}
