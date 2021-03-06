package com.personal.agenda.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.personal.agenda.model.Rol;
import com.personal.agenda.model.Usuario;
import com.personal.agenda.services.RolService;
import com.personal.agenda.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {
    
    @Autowired
    RolService rolService;
    @Autowired
    UsuarioService userService;

    @GetMapping(value="/registrar")
    public String resgistrar(HttpServletRequest request) {
        return "usuarios/registro";
    }

    @PostMapping("/registro")
    public String registro(HttpServletRequest request,Model m) {
      Usuario usuario=new Usuario();
      usuario.setNombre(request.getParameter("nombre"));
      String pass=request.getParameter("contrasenia");
      String p=DigestUtils.md5DigestAsHex(pass.getBytes());
      usuario.setContrasenia(p);
      Rol rol=rolService.getByIdRol(Integer.parseInt(request.getParameter("rol")));
      usuario.setIdrol(rol);
      usuario.setFechavencimiento(new Date());

    try {
        userService.save(usuario);
        HttpSession misession= (HttpSession) request.getSession();
        misession.setAttribute("user",usuario.getNombre());
        misession.setAttribute("rol", usuario.getIdrol().getNombre());
        misession.setAttribute("idrol", usuario.getIdrol().getId());
        m.addAttribute("user", usuario.getNombre());
        m.addAttribute("idrol", usuario.getIdrol().getId());
        return "dashboard";

    } catch (Exception e) {
        //TODO: handle exception
        System.err.println(e.getMessage());
        return "index";
    }
      
    }
}
