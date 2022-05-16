package com.ibm.academia.universidadapi.mapper;

import com.ibm.academia.universidadapi.models.dto.AulaDTO;
import com.ibm.academia.universidadapi.models.entities.Aula;
import org.springframework.stereotype.Component;

@Component
public class AulaMapper {
  public static AulaDTO mapAula(Aula aula){
    return new AulaDTO(
            aula.getId(),
            aula.getNumeroAula(),
            aula.getTipoPizarron()
    );
  }
}
