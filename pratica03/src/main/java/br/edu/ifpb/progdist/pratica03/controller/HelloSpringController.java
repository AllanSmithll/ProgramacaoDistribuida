package br.edu.ifpb.progdist.pratica03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloSpringController {

    @GetMapping("/hello")
    public void hello() {
        System.out.println("Olá");
    }
}
