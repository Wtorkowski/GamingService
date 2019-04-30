package com.gamingService.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registered_successfully")
public class RegisteredSuccessfullyController {

    @GetMapping
    public String prepareRegSuccPage() {
        return "registered_successfully";
    }
}