package com.desafiouno.web.rest;

import com.desafiouno.domain.RptServicio;
import com.desafiouno.service.DesafioService;
import com.desafiouno.service.ExecuteJarService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * DesafioResource controller
 */
@RestController
@RequestMapping("/api/desafio")
public class DesafioResource {

    private final Logger log = LoggerFactory.getLogger(DesafioResource.class);

    private final DesafioService desafioService;

    private  final ExecuteJarService executeJarService;

    public DesafioResource(DesafioService desafioService,ExecuteJarService executeJarService){
        this.desafioService = desafioService;
        this.executeJarService = executeJarService;
    }
    @GetMapping("/ejecuta-servicioDatos")
    public Boolean ejecuta(){
        try {
            return executeJarService.executeCodeAnalysisJar();
        }catch (Exception ex ){
            return  false;
        }
    }
    /**
    * POST invocaGDD
    */
    @PostMapping("/invoca-gdd")
    public String invocaGDD() {
        try {
            Gson gson = new Gson();
            JsonObject json = desafioService.getDatos();

            List<String> fechasFaltantes = new LinkedList<>();
            RptServicio rptServicio = gson.fromJson(json, RptServicio.class);

            // todo: aqui logica para recuperar los periodos faltantes.

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(rptServicio.getFechaCreacion(), formatter);
            LocalDate localDate1 =  LocalDate.parse(rptServicio.getFechaFin(), formatter);
            Period period = Period.between(localDate, localDate1);

            List<LocalDate> listaFechas = new ArrayList<LocalDate>();
            while (!localDate.isAfter(localDate1)) {
                listaFechas.add(localDate);
                localDate = localDate.plusMonths(1);
            }

            for(int i = 0 ; i< listaFechas.size(); i++){
                int contador = 0;
                for(int j = 0; j< rptServicio.getFechas().length; j++){
                   if(listaFechas.get(i).format(formatter).equals(rptServicio.getFechas()[j])){
                       contador++;
                   }
                }
                if(contador == 0) {
                    fechasFaltantes.add(listaFechas.get(i).format(formatter));
                }
            }
            rptServicio.setFechasFaltantes(fechasFaltantes);
            String JSON = gson.toJson(rptServicio);
            return JSON;
        }
        catch (Exception ex ){
             return  null;
        }

    }


}
