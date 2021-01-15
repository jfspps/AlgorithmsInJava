package com.algo_web.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }
}
