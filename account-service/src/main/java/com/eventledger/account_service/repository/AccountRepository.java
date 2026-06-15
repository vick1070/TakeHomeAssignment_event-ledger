package com.eventledger.account_service.repository;

import com.eventledger.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}