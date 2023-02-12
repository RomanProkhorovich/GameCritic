package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add_new_title")
public class AddNewTitleController {

    @GetMapping
    public String printFormToAdd(){
        return "add_new_title";
    }

}
