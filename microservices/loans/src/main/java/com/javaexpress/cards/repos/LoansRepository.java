package com.javaexpress.cards.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.cards.models.Loans;

public interface LoansRepository extends JpaRepository<Loans, Long>{

	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
