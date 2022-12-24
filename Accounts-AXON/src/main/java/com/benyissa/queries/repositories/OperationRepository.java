package com.benyissa.queries.repositories;

import com.benyissa.queries.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
