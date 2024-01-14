package com.example.esaSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/hello")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        //model.addAttribute("message", "Hello, world!");
        return "hello"; // Имя представления (шаблона) для отображения содержимого "Hello, world!"
    }
}