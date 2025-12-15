package com.zudum1.zudum1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    /**
     * Dashboard interno / vista antigua
     * ⚠️ NO usar "/"
     * "/" lo maneja CatalogoController
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "index";
    }
}
