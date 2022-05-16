package com.ibm.academia.universidadapi.repositories;

import com.ibm.academia.universidadapi.enums.TipoPizarron;
import com.ibm.academia.universidadapi.models.entities.Aula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {
  
  Iterable<Aula> findAulasByPizarron(TipoPizarron pizarron);

  Iterable<Aula> findAulasByPabellonNombre(String nombre);

  Aula findAulaByNumeroAula(Integer numeroAula);

}
