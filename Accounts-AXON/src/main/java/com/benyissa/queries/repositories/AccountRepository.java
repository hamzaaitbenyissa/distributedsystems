package com.benyissa.queries.repositories;

import com.benyissa.queries.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
