package com.personal.agenda.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personal.agenda.idao.IRolDao;
import com.personal.agenda.model.Rol;
import com.personal.agenda.model.Usuario;
import com.personal.agenda.services.RolService;
import com.personal.agenda.services.UsuarioService;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.DigestUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    RolService rolService;
    @Autowired
    UsuarioService userService;
    
    @GetMapping(value="/")
    public String index() {
        return "index";
    }

    @PostMapping(value="/login")
    public String login(HttpServletRequest request,Model model) {
        HttpSession misession= (HttpSession) request.getSession();

        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        String p=DigestUtils.md5DigestAsHex(pass.getBytes());
        Usuario u=userService.validUser(user, p);

        if(u!=null){
            misession.setAttribute("user",u.getNombre());
            misession.setAttribute("rol", u.getIdrol().getNombre());
            misession.setAttribute("idrol", u.getIdrol().getId());
            model.addAttribute("user", u.getNombre());
            model.addAttribute("idrol", u.getIdrol().getId());
            return "dashboard";
        }else{
            model.addAttribute("error", "Usuario o Cantraseña incorrecta");
            return "index";
        }

    }

    @GetMapping(value="/logout")
    public String logout(HttpServletRequest request) {
        HttpSession misession= (HttpSession) request.getSession();
        misession.invalidate();
        return "index";
    }
   
    
}
