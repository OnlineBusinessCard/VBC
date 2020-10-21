package com.vbc.vbc.repositories;

import com.vbc.vbc.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    @Query("from Lead a where a.cardOwner.id = ?1")
    List<Lead> findAllAppointmentsByCardOwner(long cardOwnerId);

    @Query("from Lead l where l.user.id = ?1")
    List<Lead> findAllLeadsByAuthor(long userId);

}
