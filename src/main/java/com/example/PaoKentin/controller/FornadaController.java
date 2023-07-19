package com.example.PaoKentin.controller;

import com.example.PaoKentin.model.Fornada;
import com.example.PaoKentin.model.Pao;
import com.example.PaoKentin.repository.FornadaRepository;
import com.example.PaoKentin.repository.PaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FornadaController {

    @Autowired
    private PaoRepository paoRepo;

    @Autowired
    private FornadaRepository fornadaRepo;

    @GetMapping(value = "fornadas")
    public String getFornadas(Model model) {

        Iterable<Pao> paes = paoRepo.readAll();
        Iterable<Fornada> fornadas = fornadaRepo.readAll();

        List<Fornada> fornadasProntas = new ArrayList<>();
        List<Fornada> fornadasEmPreparo = new ArrayList<>();

        LocalTime tempoAtual = LocalTime.now();
        Duration tempoRestante;

        for(Fornada fornada : fornadas) {

           boolean isAfter = tempoAtual.isAfter(fornada.getFinalFornada());
           if(isAfter){
               fornadasProntas.add(fornada);
           } else {
               tempoRestante = Duration.between(tempoAtual, fornada.getFinalFornada());

               System.out.println("DURATION: " + tempoRestante);

               long durationMinutes = (tempoRestante.toMinutes()) + 1;
               System.out.println("TESTEEEZINHOO " + durationMinutes);
               fornadasEmPreparo.add(fornada);
               fornada.setTempoRestante((int) durationMinutes);
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
    public String registrarFornada(@ModelAttribute("fornada") Fornada fornada) throws SQLException {

        int idPao = fornada.getPao().getId();

        Pao pao = paoRepo.read(idPao);

        int tempoDePreparo = pao.getTempoPreparo();
        LocalTime tempoInicial = LocalTime.now();
        LocalTime tempoFinal = tempoInicial.plus(Duration.ofMinutes(tempoDePreparo));

        fornada.setInicioFornada(tempoInicial);
        fornada.setTempoRestante((int) ((Duration.between(tempoInicial, tempoFinal).toMinutes()) + 1));
        fornada.setFinalFornada(tempoFinal);

        fornadaRepo.create(fornada);
        return "redirect:/fornadas";
    }


}
