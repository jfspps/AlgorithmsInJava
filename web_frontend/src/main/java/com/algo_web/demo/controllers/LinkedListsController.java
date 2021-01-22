package com.algo_web.demo.controllers;

import com.algo_data.linkedLists.FindKthToLast;
import com.algo_data.linkedLists.LinkedList;
import com.algo_data.linkedLists.PartitionAtNodeP;
import com.algo_data.linkedLists.RemoveDuplicates;
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
}
