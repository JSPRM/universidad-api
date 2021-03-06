package com.ibm.academia.universidadapi.controllers;

import com.ibm.academia.universidadapi.exceptions.NotFoundException;
import com.ibm.academia.universidadapi.models.entities.Carrera;
import com.ibm.academia.universidadapi.models.entities.Persona;
import com.ibm.academia.universidadapi.services.AlumnoDAO;
import com.ibm.academia.universidadapi.services.CarreraDAO;
import com.ibm.academia.universidadapi.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController 
{
	private final PersonaDAO alumnoDao;
	
	private final CarreraDAO carreraDao;

	@Autowired
	public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDao) {
		this.alumnoDao = alumnoDao;
		this.carreraDao = carreraDao;
	}

	@PostMapping
	public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno) {
		Persona alumnoGuardado = alumnoDao.guardar(alumno);
		return new ResponseEntity<>(alumnoGuardado, HttpStatus.CREATED);
	}
	

	@GetMapping("/alumnos/lista")
	public ResponseEntity<?> obtenerTodos() {
		List<Persona> alumnos = (List<Persona>) alumnoDao.buscarTodos();
		
		if(alumnos.isEmpty())
			throw new NotFoundException("No existen alumnos");
		return new ResponseEntity<>(alumnos, HttpStatus.OK);
	}
	

	@GetMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer alumnoId) {
        Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
        
        if(oAlumno.isEmpty())
            throw new NotFoundException(String.format("Alumno con id %d no existe", alumnoId));
        
        return new ResponseEntity<>(oAlumno.get(), HttpStatus.OK);
    }
	

	@PutMapping("/upd/alumnoId/{alumnoId}")
	public ResponseEntity<?> actualizarAlumno(@PathVariable Integer alumnoId, @RequestBody Persona alumno) {
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		
		if(oAlumno.isEmpty())
			throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));
		
		Persona alumnoActualizado = ((AlumnoDAO)alumnoDao).actualizar(oAlumno.get(), alumno);
		return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
	}
	

	@DeleteMapping("/alumnoId/{alumnoId}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Integer alumnoId) {
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		
		if(oAlumno.isEmpty())
			throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));
		
		alumnoDao.eliminarPorId(oAlumno.get().getId()); 
		
		return new ResponseEntity<>("Alumno ID: " + alumnoId + " se elimino satisfactoriamente", HttpStatus.NO_CONTENT);
	}
	

	@PutMapping("/alumnoId/{alumnoId}/carrera/{carreraId}")
	public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId, @PathVariable Integer alumnoId) {
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
        if(oAlumno.isEmpty())
            throw new NotFoundException(String.format("Alumno con id %d no existe", alumnoId));
        
        Optional<Carrera> oCarrera = carreraDao.buscarPorId(carreraId);
        if(oCarrera.isEmpty())
            throw new NotFoundException(String.format("Carrera con id %d no existe", carreraId));
        
        Persona alumno = ((AlumnoDAO)alumnoDao).asociarCarreraAlumno(oAlumno.get(), oCarrera.get());
        
        return new ResponseEntity<>(alumno, HttpStatus.OK);
	}
}
