package com.vbc.vbc.repositories;

import com.vbc.vbc.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
