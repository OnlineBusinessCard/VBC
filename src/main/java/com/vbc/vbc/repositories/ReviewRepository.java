package com.vbc.vbc.repositories;

import com.vbc.vbc.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("from Review r where r.user.id = ?1")
    List<Review> findAllReviewsByUser(long userId);

//    @Query("from Review r where r.author.id = ?1")
//    List<Review> findAllReviewsByAuthor(long userId);

}
