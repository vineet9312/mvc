package com.javaexpress.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.accounts.model.Account;

public interface AccountsRepository extends JpaRepository<Account, Integer> {

	Account findByCustomerId(int customerId);

}
