package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://localhost:8090/api/ex1
@RestController
@RequestMapping ("/api/ex1")
public class ex1 {

    @GetMapping("Helloy1")
    public String helloWorld(){
        return "Hellou";

    }
    
}
