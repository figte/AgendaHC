package com.personal.agenda.services;

import java.util.List;

import com.personal.agenda.idao.IRolDao;
import com.personal.agenda.model.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    
    @Autowired
    IRolDao dao; //instancia inyectada

    public List<Rol> getAll(){
        List<Rol> list = null;
		try {
			list = (List<Rol>) dao.findAll();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
		return list;
    }
    public Rol getByIdRol(Integer id){
        Rol r = null;
		try {
			r = dao.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
		return r;
    }

}
