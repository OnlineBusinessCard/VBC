package com.vbc.vbc.repositories;

import com.vbc.vbc.models.Image;
import com.vbc.vbc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("SELECT u FROM Image u WHERE u.user = ?1")
    List<Image> findImageById(User Id);

}
