package com.algo_web.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/linkedlists")
public class LinkedListsController {

    @GetMapping({"/", ""})
    public String getIndex(){
        return "/linkedlists/index";
    }

    @GetMapping("/customLinkedList")
    public String getLinkedList(){
        return "/linkedlists/customLinkedList";
    }
}
