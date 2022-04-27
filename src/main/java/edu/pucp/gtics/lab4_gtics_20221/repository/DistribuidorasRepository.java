package edu.pucp.gtics.lab4_gtics_20221.repository;

import edu.pucp.gtics.lab4_gtics_20221.DTO.DistribuidorasDTO;
import edu.pucp.gtics.lab4_gtics_20221.entity.Distribuidoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository

public interface DistribuidorasRepository extends JpaRepository<Distribuidoras,Integer> {

    @Query(nativeQuery = true,value = "SELECT d.iddistribuidora,d.nombre,d.descripcion,d.fundacion,d.web, p.nombre as 'nombresede' from distribuidoras d left JOIN paises p on p.idpais = d.idsede;")
    List<DistribuidorasDTO> distribuidorasListar();
}
