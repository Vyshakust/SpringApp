package com.ust.claims.api.claims;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ClaimsRepository extends JpaRepository<Claims,Integer> {
}
