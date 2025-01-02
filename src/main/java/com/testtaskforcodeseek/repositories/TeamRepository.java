package com.testtaskforcodeseek.repositories;

import com.testtaskforcodeseek.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
}
