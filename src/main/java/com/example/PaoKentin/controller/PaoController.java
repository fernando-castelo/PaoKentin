package com.example.PaoKentin.controller;

import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.service.PaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaoController {

    @Autowired
    private PaoService paoService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/")
    public String createPao(@ModelAttribute("pao")Pao pao, Model model) {

        paoService.createPao(pao.getTipoPao(), pao.getDescricao(), pao.getTempoPreparo());

        System.out.println(pao.getDescricao());
        System.out.println(pao.getTipoPao());

        Iterable<Pao> paes = paoService.getPaes();
        model.addAttribute("paes", paes);
        return "index";
    }
}
