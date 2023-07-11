package com.example.PaoKentin.controller;

import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.service.PaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaoController {

    @Autowired
    private PaoService paoService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/cadastroPao")
        public String getCadastroPao(Model model) {

        Iterable<Pao> paes = paoService.getPaes();
        model.addAttribute("paes", paes);
        return "cadastroPao";
    }

    @PostMapping(value = "/")
    public String createPao(@ModelAttribute("pao")Pao pao, Model model) {

        paoService.createPao(pao.getTipoPao(), pao.getDescricao(), pao.getTempoPreparo());

        return "redirect:/cadastroPao";
    }


}
