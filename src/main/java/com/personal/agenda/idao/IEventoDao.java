package com.personal.agenda.idao;

import com.personal.agenda.model.Evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventoDao extends CrudRepository<Evento,Integer>{
    
}
