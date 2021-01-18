package com.algo_web.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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

    @GetMapping({"/allUniqueChars"})
    public String getAllUniqueChars(){
        return "/arrays/allUniqueChars";
    }

    @GetMapping("/allUniqueChars/with")
    public String postUniqueWith(String asciiStringWith){
        log.info(asciiStringWith);
        return "/arrays/allUniqueChars";
    }

    @GetMapping("/allUniqueChars/without")
    public String postUniqueWithout(String asciiStringWithout){
        log.info(asciiStringWithout);
        return "/arrays/allUniqueChars";
    }
}
