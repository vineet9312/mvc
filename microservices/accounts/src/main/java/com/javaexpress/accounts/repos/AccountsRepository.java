package com.javaexpress.accounts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.accounts.models.Account;

public interface AccountsRepository extends JpaRepository<Account, Long>{

	Account findByCustomerId(int customerId);
}
