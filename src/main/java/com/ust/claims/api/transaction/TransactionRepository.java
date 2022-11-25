package com.ust.claims.api.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
