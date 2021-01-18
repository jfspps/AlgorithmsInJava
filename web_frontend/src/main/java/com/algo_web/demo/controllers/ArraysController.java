package com.algo_web.demo.controllers;

import com.algo_data.arrays.AllUniqueChars;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping({"/allUniqueChars/demo"})
    public String getAllUniqueCharsDemo(){
        return "/arrays/allUniqueCharsDemo";
    }

    @PostMapping("/allUniqueChars/with")
    public String postUniqueWith(String asciiStringWith, Model model){
        log.info(asciiStringWith);
        AllUniqueChars uniqueChars = new AllUniqueChars(asciiStringWith);
        String message = "Entered: " + asciiStringWith + ". String is unique: " + uniqueChars.areAllUniqueChars_withADT();
        model.addAttribute("uniqueResult", message);
        return "/arrays/allUniqueCharsDemo";
    }

    @PostMapping("/allUniqueChars/without")
    public String postUniqueWithout(String asciiStringWithout, Model model){
        log.info(asciiStringWithout);
        AllUniqueChars uniqueChars = new AllUniqueChars(asciiStringWithout);
        String message = "Entered: " + asciiStringWithout + ". String is unique: " + uniqueChars.areAllUniqueChars_withoutADT();
        model.addAttribute("uniqueResult2", message);
        return "/arrays/allUniqueCharsDemo";
    }
}
