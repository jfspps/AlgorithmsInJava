package com.algo_web.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/stacksAndQueues")
public class StacksQueuesController {

    @GetMapping("/")
    String getIndex() {
        return "/stacksAndQueues/index";
    }

    @GetMapping("/listStack")
    String getListStack() {
        return "/stacksAndQueues/Stack_linkedList";
    }

    @GetMapping("/arrayStack")
    String getArrayStack() {
        return "/stacksAndQueues/Stack_array";
    }

    @GetMapping("/listQueue")
    String getListQueue() {
        return "/stacksAndQueues/Queue_linkedList";
    }

    @GetMapping("/arrayOfThree")
    String getArrayOfThreeStacks() {
        return "/stacksAndQueues/ArrayOfThreeStacks";
    }

    @GetMapping("/arrayStackWithMin")
    String getArrayOfStacks() { return "/stacksAndQueues/StackArrayWithMin"; }

    @GetMapping("/setOfStacks")
    String getSetOfStacks() { return "/stacksAndQueues/SetOfStacks"; }

    @GetMapping("/QueueAsStacks")
    String getQueueFromStacks() { return "/stacksAndQueues/Queue_stacks"; }

    @GetMapping("/smallTop")
    String getSmallAtTop() { return "/stacksAndQueues/smallTop"; }

    @GetMapping("/animalShelter")
    String getAnimalShelter() { return "/stacksAndQueues/animalShelter"; }
}
