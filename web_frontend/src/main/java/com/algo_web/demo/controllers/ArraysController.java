package com.algo_web.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/arrays"})
public class ArraysController {

    @GetMapping({"/", ""})
    public String getIndex() {
        return "/arrays/index";
    }

    @GetMapping({"/customArrayList"})
    public String getCustomArrayList() {
        return "/arrays/customArrayList";
    }

}
