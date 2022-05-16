package com.ibm.academia.universidadapi.services;

import com.ibm.academia.universidadapi.models.entities.Carrera;
import com.ibm.academia.universidadapi.models.entities.Persona;

import java.util.Optional;

public interface ProfesorDAO extends PersonaDAO {
  
  Optional<Iterable<Persona>> findProfesoresByCarrera(String carrera);

  Optional<Persona> updateProfesor(Persona actualProfesor, Persona profesorChanged);

  Optional<Persona> addProfessorToCareer(Persona professor, Carrera career);
}
