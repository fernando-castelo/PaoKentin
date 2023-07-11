package com.example.PaoKentin.controller;

import com.example.PaoKentin.model.Fornada;
import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.service.FornadaService;
import com.example.PaoKentin.service.PaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FornadaController {

    @Autowired
    private PaoService paoService;

    @Autowired
    private FornadaService fornadaService;

    @GetMapping(value = "fornadas")
    public String getFornadas(Model model) {

        Iterable<Pao> paes = paoService.getPaes();
        Fornada fornada = new Fornada();

        model.addAttribute("listaPaes", paes);
        model.addAttribute("fornada", fornada);

        return "cadastroFornada";
    }

    @PostMapping(value = "registrarFornada")
    public String registrarFornada(@ModelAttribute("fornada") Fornada fornada) {

        System.out.println("TESTEEEEE");
        fornadaService.createFornada(fornada);
        return "redirect:/fornadas";
    }


//    @GetMapping(value = "/registrarFornada/{id}")
//    public String registrarFornada(@PathVariable("id") String id) {
//
//        System.out.println("TESTEEEE" + id);
//        return "redirect:/fornadas";
//    }
}
