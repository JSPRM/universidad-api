package com.ibm.academia.universidadapi.services;

import com.ibm.academia.universidadapi.enums.TipoEmpleado;
import com.ibm.academia.universidadapi.models.entities.Persona;

import java.util.Optional;

public interface EmpleadoDAO extends PersonaDAO {
  
  Optional<Iterable<Persona>> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

  Optional<Persona> updateEmployee(Persona actual, Persona changed);
}
