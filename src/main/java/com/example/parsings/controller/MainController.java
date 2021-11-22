package com.example.parsings.controller;

import com.example.parsings.models.Values;
import com.example.parsings.service.ParsingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    //private static final String Main_Page = "main";
    //private static final String JSON_URL = "https://cex.io/api/last_price/{symbol1}/{symbol2}";

    @Autowired
    private ParsingService parsingService;

    /*@GetMapping("/main")

    public String main(final Model model){
        List<Values> valuesList =(List<Values>) parsingService.parse(JSON_URL);
        model.addAttribute("values", valuesList.get(0));

        return Main_Page;
    }*/
    @GetMapping(value = "/value")
    public List<Values> getAllValues(){
        return parsingService.getAllValue();
    }




}
