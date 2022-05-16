package com.ibm.academia.universidadapi.services;

import com.ibm.academia.universidadapi.enums.TipoPizarron;
import com.ibm.academia.universidadapi.models.entities.Aula;
import com.ibm.academia.universidadapi.models.entities.Pabellon;

import java.util.List;
import java.util.Optional;

public interface AulaDAO extends GenericoDAO<Aula> {
  
  Optional<List<Aula>> findAulasByPizarron(TipoPizarron pizarron);
  
  Optional<List<Aula>> findAulasByPabellonNombre(String nombre);
  
  Optional<Aula> findAulaByNumeroAula(Integer numeroAula);

  Optional<Aula> update(Aula actual, Aula changed);

  Optional<Aula> addPabellonToAula(Aula aulaFound, Pabellon pabellonFound);

}
