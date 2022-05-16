package com.ibm.academia.universidadapi.services;

import com.ibm.academia.universidadapi.models.entities.Carrera;
import com.ibm.academia.universidadapi.models.entities.Persona;

public interface AlumnoDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);
    Persona actualizar(Persona alumnoEncontrado, Persona alumno);
    Persona asociarCarreraAlumno(Persona alumno, Carrera carrera);
}