package com.vaccination.citizenService.repository;

import com.vaccination.citizenService.entity.CitizenEntity;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenRepo extends JpaRepository<CitizenEntity, Integer> {

    @Override
    Optional<CitizenEntity> findById(Integer id);

    @Query(value = "Select c from CitizenEntity c where c.vaccinationCenterID = :vacId")
    List<CitizenEntity> findByVacID(@QueryParam("vacId") Integer vacId);

}
