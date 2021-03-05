package com.personal.agenda.idao;

import com.personal.agenda.model.Rol;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolDao extends CrudRepository<Rol,Integer>{
    
}
