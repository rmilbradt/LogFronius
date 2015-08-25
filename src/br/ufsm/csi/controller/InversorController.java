package br.ufsm.csi.controller;

import br.ufsm.csi.beans.InversorDAO;
import br.ufsm.csi.model.Inversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 201420240 on 14/08/2015.
 */

@Controller
public class InversorController {

    @Autowired
    private InversorDAO dao;

    @RequestMapping("cadastraInversor.html")
    public String cadastra(Inversor inversor, String acao) {
        if (acao != null && acao.equals("Cadastrar")) {
            dao.gravaInversor(inversor);
        }
        return "cadastraInversor";
    }

    @RequestMapping("listaInversores.html")
    public String inversores(Model model) {
        List<Inversor> inversores = dao.findInversores();
        model.addAttribute("inversores", inversores);
        return "listaInversores";
    }
}
