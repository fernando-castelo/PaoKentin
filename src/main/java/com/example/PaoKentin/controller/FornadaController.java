package com.example.PaoKentin.controller;

import com.example.PaoKentin.model.Fornada;
import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.model.StatusFornada;
import com.example.PaoKentin.service.FornadaService;
import com.example.PaoKentin.service.PaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FornadaController {

    @Autowired
    private PaoService paoService;

    @Autowired
    private FornadaService fornadaService;

    @GetMapping(value = "fornadas")
    public String getFornadas(Model model) {

        Iterable<Pao> paes = paoService.getPaes();
        Iterable<Fornada> fornadas = fornadaService.getFornadas();

        List<Fornada> fornadasProntas = new ArrayList<>();
        List<Fornada> fornadasEmPreparo = new ArrayList<>();

        LocalTime tempoAtual = LocalTime.now();
        Duration tempoRestante;
//        LocalTime tempoFinal;

        for(Fornada fornada : fornadas) {
            System.out.println(tempoAtual);
            System.out.println(fornada.getFinalFornada());
            tempoRestante = Duration.between(tempoAtual, fornada.getFinalFornada());

            long durationMinutes = (tempoRestante.toMinutes()) + 1;
            System.out.println("TESTEEEZINHOO " + durationMinutes);

//            System.out.println("Tempo atual " + tempoAtual + ' ' + tempoAtual.isAfter(fornada.getFinalFornada()));
           boolean isAfter =  tempoAtual.isAfter(fornada.getFinalFornada());
           if(isAfter){
               fornadasProntas.add(fornada);
               fornada.setStatus(StatusFornada.PRONTO);
           } else {
               fornadasEmPreparo.add(fornada);
               fornada.setTempoRestante(durationMinutes);
           }
        }

        Fornada fornada = new Fornada();

        model.addAttribute("listaPaes", paes);
        model.addAttribute("fornadasProntas", fornadasProntas);
        model.addAttribute("fornadasEmPreparo", fornadasEmPreparo);
        model.addAttribute("fornada", fornada);

        return "cadastroFornada";
    }

    @PostMapping(value = "registrarFornada")
    public String registrarFornada(@ModelAttribute("fornada") Fornada fornada) {

        int idPao = fornada.getPao().getId();

        Pao pao = paoService.getPao(idPao).orElse(null);

        int tempoDePreparo = pao.getTempoPreparo();
        LocalTime tempoInicial = LocalTime.now();
        LocalTime tempoFinal = tempoInicial.plus(Duration.ofMinutes(tempoDePreparo));
        fornada.setInicioFornada(tempoInicial);

        fornada.setTempoRestante((Duration.between(tempoInicial, tempoFinal).toMinutes()) + 1);
        fornada.setFinalFornada(tempoFinal);

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
