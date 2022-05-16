package com.ibm.academia.universidadapi.services;

import com.ibm.academia.universidadapi.models.entities.Direccion;
import com.ibm.academia.universidadapi.models.entities.Pabellon;

import java.util.List;
import java.util.Optional;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

  Optional<List<Pabellon>> getPabellonesByDireccion(Direccion direccion);

  Optional<List<Pabellon>> getPabellonesByNombre(String nombre);

  Optional<Pabellon> updatePabellon(Pabellon actual, Pabellon changed);
}
