package com.javamentor.qa.platform.dao.abstracts.repository;

import com.javamentor.qa.platform.models.entity.user.reputation.Reputation;
import com.javamentor.qa.platform.models.entity.user.reputation.ReputationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReputationRepository extends JpaRepository<Reputation, Long> {
}
