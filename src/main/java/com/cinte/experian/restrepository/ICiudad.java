package com.cinte.experian.restrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinte.experian.domain.Ciudad;

@RepositoryRestResource(path= "/ciudades", itemResourceRel= "ciudad", collectionResourceRel= "ciudades")
public interface ICiudad extends JpaRepository<Ciudad, Long> {

}
