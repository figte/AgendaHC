package com.personal.agenda.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import com.personal.agenda.idao.ICategoriaDao;
import com.personal.agenda.model.Categoria;
import com.personal.agenda.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    ICategoriaDao dao;

    @GetMapping(value="/index")
    public String getMethodName(HttpServletRequest request, Model model) {
        model.addAttribute("items",(List<Categoria>) dao.findAll());
        HttpSession misession= (HttpSession) request.getSession();
        model.addAttribute("user", misession.getAttribute("user"));
        model.addAttribute("idrol", misession.getAttribute("idrol"));
        return "categorias/index";
    }
    @GetMapping(value="/nuevo")
    public String nuevo(Model model) {
      
        return "categorias/nuevo";
    }

    @GetMapping(value="/mod/{id}")
    public String nuevo(@PathVariable Integer id,Model model) {
        Categoria categoria= dao.findById(id).get();
        model.addAttribute("categoria", categoria);
        return "categorias/edit";
    }

    @PostMapping(value="/save")
    public String save(@RequestBody Categoria entity) {  
        dao.save(entity);
        return "categorias/index";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        Categoria categoria= dao.findById(id).get();
        dao.delete(categoria);
        return "categorias/index";
    }
    
    

}
