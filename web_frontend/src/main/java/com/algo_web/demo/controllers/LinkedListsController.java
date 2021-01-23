package com.algo_web.demo.controllers;

import com.algo_data.linkedLists.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/removeDuplicates")
    public String getRemoveDuplicates(){
        return "/linkedlists/removeDuplicates";
    }

    @GetMapping("/removeDuplicates/demo")
    public String getRemoveDuplicatesDemo(){
        return "/linkedlists/removeDuplicatesDemo";
    }

    @PostMapping("/removeDuplicates/demo")
    public String postRemoveDuplicatesDemo(String one, String two, String three, String four, String five, String six,
                                           String seven, String eight, String nine, Model model){
        Integer[] numberList = {
                Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three),
                Integer.parseInt(four), Integer.parseInt(five), Integer.parseInt(six),
                Integer.parseInt(seven), Integer.parseInt(eight), Integer.parseInt(nine)
        };

        LinkedList<Integer> integerLinkedList = new LinkedList<>(numberList);
        model.addAttribute("unprocessed", integerLinkedList.printToString());

        RemoveDuplicates<Integer> removeDuplicates = new RemoveDuplicates<>(integerLinkedList);
        removeDuplicates.removeDuplicatesWithTally();
        model.addAttribute("processed", integerLinkedList.printToString());

        LinkedList<Integer> integerLinkedListWithout = new LinkedList<>(numberList);
        RemoveDuplicates<Integer> removeDuplicatesWithout = new RemoveDuplicates<>(integerLinkedListWithout);
        removeDuplicatesWithout.removeDuplicatesWithTally();
        model.addAttribute("processed2", integerLinkedListWithout.printToString());

        return "/linkedlists/removeDuplicatesDemo";
    }

    @GetMapping("/kthToLast")
    public String getkthToLast(){
        return "/linkedlists/findKthToLast";
    }

    @GetMapping("/kthToLast/demo")
    public String getkthToLastDemo(){
        return "/linkedlists/findKthToLastDemo";
    }

    @PostMapping("/kthToLast/demo")
    public String postkthToLastDemo(String one, String two, String three, String four, String five, String six,
                                           String seven, String eight, String nine, String kValue, Model model) {
        Integer[] numberList = {
                Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three),
                Integer.parseInt(four), Integer.parseInt(five), Integer.parseInt(six),
                Integer.parseInt(seven), Integer.parseInt(eight), Integer.parseInt(nine)
        };

        LinkedList<Integer> integerLinkedList = new LinkedList<>(numberList);
        FindKthToLast<Integer> findKthToLast = new FindKthToLast<>(integerLinkedList);

        String processed = integerLinkedList.printToString() + ", k = " + kValue +
                " is the node with a value of " + findKthToLast.findKthToLast(Integer.parseInt(kValue)).getData();

        model.addAttribute("processed", processed);
        return "/linkedlists/findKthToLastDemo";
    }

    @GetMapping("/partition")
    public String getPartitionAtNodeP(){
        return "/linkedlists/partitionAtNodeP";
    }

    @GetMapping("/partition/demo")
    public String getPartitionAtNodePDemo(){
        return "/linkedlists/partitionAtNodePDemo";
    }

    @PostMapping("/partition/demo")
    public String postPartitionAtNodePDemo(String one, String two, String three, String four, String five, String six,
                                    String seven, String eight, String nine, String pValue, Model model) {
        Integer[] numberList = {
                Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three),
                Integer.parseInt(four), Integer.parseInt(five), Integer.parseInt(six),
                Integer.parseInt(seven), Integer.parseInt(eight), Integer.parseInt(nine)
        };

        LinkedList<Integer> integerLinkedList = new LinkedList<>(numberList);
        String originalList = integerLinkedList.printToString();

        PartitionAtNodeP partitionAtNodeP = new PartitionAtNodeP(integerLinkedList);

        LinkedList<Integer> newHead = partitionAtNodeP.partition(Integer.parseInt(pValue));

        String processed = "Original list: " + originalList + ", p = " + pValue +
                "\nPartitioned list: " + newHead.printToString();

        model.addAttribute("processed", processed);
        return "/linkedlists/partitionAtNodePDemo";
    }

    @GetMapping("/sumForward")
    public String getSumForward(){
        return "/linkedlists/sumForward";
    }

    @GetMapping("/sumForward/demo")
    public String getSumForwardDemo(){
        return "/linkedlists/sumForwardDemo";
    }

    @PostMapping("/sumForward/demoEven")
    public String postSumForwardDemoEven(String one, String two, String three, String four, String five, String six,
                                           Model model) {

        Integer[] numberList = {
                Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three),
                Integer.parseInt(four), Integer.parseInt(five), Integer.parseInt(six)
        };

        LinkedList<Integer> list = new LinkedList<>(numberList);
        String originalList = list.printToString();

        SumForward sumForward = new SumForward(list);

        String output = sumForward.sumForward().printToString();
        model.addAttribute("sumEven", "Original list: " + originalList + "\nSum is: " + output);

        return "/linkedlists/sumForwardDemo";
    }

    @PostMapping("/sumForward/demoOdd")
    public String postSumForwardDemoOdd(String one, String two, String three, String four, String five,
                                     Model model) {

        Integer[] numberList = {
                Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three),
                Integer.parseInt(four), Integer.parseInt(five)
        };

        LinkedList<Integer> list = new LinkedList<>(numberList);
        String originalList = list.printToString();

        SumForward sumForward = new SumForward(list);

        String output = sumForward.sumForward().printToString();
        model.addAttribute("sumOdd", "Original list: " + originalList + "\nSum is: " + output);

        return "/linkedlists/sumForwardDemo";
    }

    @GetMapping("/reverseList")
    public String getReverseList(){
        return "/linkedlists/reverseList";
    }

    @GetMapping("/reverseList/demo")
    public String getReverseListDemo(){
        return "/linkedlists/reverseListDemo";
    }

    @PostMapping("/reverseList/demo")
    public String postReverseListDemo(String one, String two, String three, String four, String five, String six,
                                      String seven, String eight, String nine, String kValue, Model model) {
        Integer[] numberList = {
                Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three),
                Integer.parseInt(four), Integer.parseInt(five), Integer.parseInt(six),
                Integer.parseInt(seven), Integer.parseInt(eight), Integer.parseInt(nine)
        };

        Integer[] numberList2 = {
                Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three),
                Integer.parseInt(four), Integer.parseInt(five), Integer.parseInt(six),
                Integer.parseInt(seven), Integer.parseInt(eight), Integer.parseInt(nine)
        };

        LinkedList<Integer> integerLinkedList = new LinkedList<>(numberList);
        String originalList = integerLinkedList.printToString();
        String reverseList = new ReverseList<>(integerLinkedList).reverseList().printToString();

        LinkedList<Integer> integerLinkedList2 = new LinkedList<>(numberList2);
        LinkedList<Integer> found = integerLinkedList2.getNode(Integer.parseInt(kValue));
        String reverseListUpToK = "";

        if (found != null){
            reverseListUpToK = new ReverseList<>(integerLinkedList2).reverseListUpToK(found).printToString();
        } else {
            reverseListUpToK = "Node with value " + kValue + " not found";
        }

        model.addAttribute("processed", "Original list: " + originalList +
                "\nReversed list: " + reverseList + "\nReversedUpToK list: " + reverseListUpToK);

        return "/linkedlists/reverseListDemo";
    }

    @GetMapping("/palindrome")
    public String getPalindromeList(){
        return "/linkedlists/palindrome";
    }

    @GetMapping("/palindrome/demo")
    public String getPalindromeListDemo(){
        return "/linkedlists/palindromeDemo";
    }

    @PostMapping("/palindrome/demo")
    public String postPalindromeList(String input, Model model){
        if (input.isBlank()){
            model.addAttribute("output", "Empty string passed");
        } else {
            Character[] array = new Character[input.length()];
            for (int i = 0; i < input.length(); i++){
                array[i] = input.charAt(i);
            }
            ListIsAPalindrome listIsAPalindrome = new ListIsAPalindrome(new LinkedList<>(array));
            model.addAttribute("output", input + " is a palindrome: " + listIsAPalindrome.isAPalindrome());
        }
        return "/linkedlists/palindromeDemo";
    }
}
