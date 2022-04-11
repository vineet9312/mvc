package com.javaexpress.cards.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.cards.models.Cards;

public interface CardsRepository extends JpaRepository<Cards, Long>{

	List<Cards> findByCustomerId(int customerId);
}
