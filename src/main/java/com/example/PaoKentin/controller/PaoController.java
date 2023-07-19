package com.example.PaoKentin.controller;

import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.repository.PaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class PaoController {

    @Autowired
    private PaoRepository paoRepo;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/cadastroPao")
        public String getCadastroPao(Model model) {

        Iterable<Pao> paes = paoRepo.readAll();
        model.addAttribute("paes", paes);
        return "cadastroPao";
    }

    @PostMapping(value = "/")
    public String createPao(@ModelAttribute("pao")Pao pao, Model model) {

        try {
            paoRepo.create(pao);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/cadastroPao";
    }


}
