package com.cinte.experian.restrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinte.experian.domain.Pais;


@RepositoryRestResource(path= "/paises", itemResourceRel= "pais", collectionResourceRel= "Paises")
public interface IPais extends JpaRepository<Pais, Long> {

}
