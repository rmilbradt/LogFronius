package br.ufsm.csi.controller;

import br.ufsm.csi.beans.LeituraInversorDAO;
import br.ufsm.csi.model.Inversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 201420240 on 14/08/2015.
 */

@Controller
public class CadastraController {

    @Autowired
    private LeituraInversorDAO dao;

    @RequestMapping("cadastraInversor.html")
    public String relatorio (Inversor inversor) {

        return "cadastraInversor";
    }
}
