package com.ibm.academia.universidadapi.repositories;

import com.ibm.academia.universidadapi.models.entities.Direccion;
import com.ibm.academia.universidadapi.models.entities.Pabellon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

  Iterable<Pabellon> findPabellonesByDireccion(Direccion direccion);

  Iterable<Pabellon> findPabellonesByNombre(String nombre);

}
