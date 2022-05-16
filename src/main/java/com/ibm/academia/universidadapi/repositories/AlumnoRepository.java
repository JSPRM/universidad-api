package com.ibm.academia.universidadapi.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.academia.universidadapi.models.entities.Persona;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository {

	@Query("select a from Alumno a join fetch a.carrera b where b.nombre = ?1")
	Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);
}