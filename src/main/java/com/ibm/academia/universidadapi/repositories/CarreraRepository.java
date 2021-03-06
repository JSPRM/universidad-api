package com.ibm.academia.universidadapi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.universidadapi.models.entities.Carrera;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

	Iterable<Carrera> findCarrerasByCantidadAnios(Integer cantidadAnios);
	
	Iterable<Carrera> findCarrerasByNombreContains(String nombre);
	
	Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
	
	Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
	
	@Query("select a from Carrera a join fetch a.profesores b where b.nombre = ?1 and b.apellido = ?2")
	Iterable<Carrera> findCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}