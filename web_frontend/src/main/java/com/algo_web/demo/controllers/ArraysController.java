package com.algo_web.demo.controllers;

import com.algo_data.arrays.AllUniqueChars;
import com.algo_data.arrays.Palindrome;
import com.algo_data.arrays.StringIsAPermutation;
import com.algo_data.arrays.URLify;
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

    @GetMapping("/stringIsAPermutation")
    public String getIsAPermutation(){ return "/arrays/stringIsAPermutation"; }

    @GetMapping("/stringIsAPermutation/demo")
    public String getIsAPermutationDemo(){ return "/arrays/stringIsAPermutationDemo"; }

    @PostMapping("/stringIsAPermutation/demo")
    public String postIsAPermutation(String asciiString1, String asciiString2, Model model){
        log.info(asciiString1 + "  " + asciiString2);
        StringIsAPermutation stringIsAPermutation = new StringIsAPermutation(asciiString1);
        String message = asciiString1 + " and " + asciiString2 + " are permutations: " + stringIsAPermutation.isAPermutation(asciiString2);
        model.addAttribute("permutation", message);
        return "/arrays/stringIsAPermutationDemo";
    }

    @GetMapping("/URLstring")
    public String getURLString(){ return "/arrays/URLstring"; }

    @GetMapping("/URLstring/demo")
    public String getURLStringDemo(){ return "/arrays/URLstringDemo"; }

    @PostMapping("/URLstring/demo")
    public String postURLStringDemo(String stringEntered, Model model){
        log.info(stringEntered);
        URLify urLify = new URLify(stringEntered);
        String message = "\"" + stringEntered + "\" converted to " + "\"" + urLify.URLifyString() + "\"";
        model.addAttribute("newURL", message);
        return "/arrays/URLstringDemo";
    }

    @GetMapping("/palindrome")
    public String getPalindrome(){ return "/arrays/palindrome"; }

    @GetMapping("/palindrome/demo")
    public String getPalindromeDemo(){ return "/arrays/palindromeDemo"; }

    @PostMapping("/palindrome/demo")
    public String postPalindrome(String stringEntered, Model model){
        log.info(stringEntered);
        Palindrome palindrome = new Palindrome(stringEntered);
        String message = "\"" + stringEntered + "\" is a palindrome: " + palindrome.stringIsAPermutationOfAPalindrome();
        model.addAttribute("palindrome", message);
        return "/arrays/palindromeDemo";
    }
}
