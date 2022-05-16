package com.ibm.academia.universidadapi.services;

import com.ibm.academia.universidadapi.models.entities.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
