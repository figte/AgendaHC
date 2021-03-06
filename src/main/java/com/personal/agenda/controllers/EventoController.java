package com.personal.agenda.controllers;

import java.util.List;

import com.personal.agenda.idao.IEventoDao;
import com.personal.agenda.model.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("eventos")
public class EventoController{
    
    @Autowired
    IEventoDao dao;

    @GetMapping(value="/index")
    public String getMethodName(Model model) {
        model.addAttribute("items",(List<Evento>) dao.findAll());
        return "eventos/index";
    }
}
