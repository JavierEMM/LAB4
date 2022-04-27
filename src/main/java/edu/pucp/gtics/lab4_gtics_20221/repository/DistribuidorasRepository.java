package edu.pucp.gtics.lab4_gtics_20221.repository;

import edu.pucp.gtics.lab4_gtics_20221.entity.Distribuidoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository

public interface DistribuidorasRepository extends JpaRepository<Distribuidoras,Integer> {

    @Query(nativeQuery = true,value = "")
}
