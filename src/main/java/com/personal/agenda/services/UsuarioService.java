package com.personal.agenda.services;

import java.util.List;

import com.personal.agenda.idao.IUsuarioDao;
import com.personal.agenda.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    IUsuarioDao dao;

    public List<Usuario> getAll() {
        List<Usuario> list = null;
		try {
			list = (List<Usuario>) dao.findAll();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return list;
        
    }

	public Usuario getById(Integer id){
		Usuario usuario=null;
		try {
			usuario=dao.findById(id).get();
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println(e.getMessage());
		}

		return usuario;
	}

	public void save(Usuario usuario){
		 try {
			 dao.save(usuario);
		 } catch (Exception e) {
			 //TODO: handle exception
			 System.err.println(e.getMessage());
		 }
	}

	public void update(Usuario usuario){
		try {
			dao.save(usuario);
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println(e.getMessage());
		}
   }
   public void delete(Usuario usuario){
		try {
			dao.delete(usuario);
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println(e.getMessage());
		}	
	}

	public Usuario validUser(String user, String pass){
		try {
			Usuario usuario=dao.getUsuarioName(user, pass);
			
           return usuario;
		} catch (Exception e) {
			//TODO: handle exception
			return null;
		}
	}

    
}
