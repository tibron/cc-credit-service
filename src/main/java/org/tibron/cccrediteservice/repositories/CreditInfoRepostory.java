package org.tibron.cccrediteservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tibron.cccrediteservice.domain.CreditInfromation;

import java.util.UUID;

@Repository
public interface CreditInfoRepostory extends JpaRepository<CreditInfromation,UUID> {
}
