package com.vbc.vbc.repositories;

import com.vbc.vbc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findById(long id);

//    @Query("from User u where u.isOwner = true")
//    List<User> findAllCardOwners();

//    User findByUser(User user);

}
