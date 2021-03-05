package com.personal.agenda.idao;

import com.personal.agenda.model.Categoria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICategoriaDao extends CrudRepository<Categoria,Integer>{
    
}
