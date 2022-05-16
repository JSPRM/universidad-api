package com.ibm.academia.universidadapi.repositories;

import com.ibm.academia.universidadapi.enums.TipoPizarron;
import com.ibm.academia.universidadapi.models.entities.Aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {

  Iterable<Aula> findAulasByTipoPizarron(TipoPizarron pizarron);

  Iterable<Aula> findAulasByPabellonNombre(String nombre);

  Aula findAulaByNumeroAula(Integer numeroAula);

}
