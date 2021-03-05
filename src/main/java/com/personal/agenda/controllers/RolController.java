package com.personal.agenda.controllers;

import com.personal.agenda.services.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("roles")
public class RolController {

    @Autowired
    RolService service;
    
    @GetMapping(value="index")
    public String getMethodName(Model model) {
        model.addAttribute("items", service.getAll());
        return "roles/index";
    }
    
}
