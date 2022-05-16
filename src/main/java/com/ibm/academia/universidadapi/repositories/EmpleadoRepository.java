package com.ibm.academia.universidadapi.repositories;

import com.ibm.academia.universidadapi.enums.TipoEmpleado;
import com.ibm.academia.universidadapi.models.entities.Persona;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository {

  @Query("select a from Empleado a where a.tipoEmpleado = ?1")
  Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}