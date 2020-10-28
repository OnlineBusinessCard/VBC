package com.vbc.vbc.repositories;

import com.vbc.vbc.models.Card;
import com.vbc.vbc.models.CardOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByCardOwner(CardOwner cardOwner);

}
