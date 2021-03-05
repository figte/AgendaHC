package com.personal.agenda.idao;

import com.personal.agenda.model.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario,Integer>{
    
    @Query("SELECT user  FROM Usuario user WHERE user.nombre = :user and user.contrasenia = :pass")
	Usuario getUsuarioName(@Param("user") String user,@Param("pass") String pass);
}
