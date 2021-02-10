package com.softuni.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exercises")
public class ExersiceController {

    @GetMapping("/add")
    public String add() {
        return "exercise-add";
    }
}
