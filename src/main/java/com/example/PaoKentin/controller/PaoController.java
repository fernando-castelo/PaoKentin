package com.example.PaoKentin.controller;

import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.repository.PaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "alterarPao")
    public String alterarPao(@RequestParam String id, Model model) {
        Pao pao = paoRepo.read(Integer.parseInt(id));

        System.out.println("TESTEE : " + pao.getTipoPao() + " " + pao.getDescricao());
        model.addAttribute("pao", pao);
        return "pao";
    }

    @PostMapping(value = "atualizarPao")
    public String atualizarPao(@ModelAttribute("pao") Pao pao) {

        paoRepo.update(pao);
        return "redirect:/cadastroPao";
    }



}
