package com.vbc.vbc.repositories;

import com.vbc.vbc.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
