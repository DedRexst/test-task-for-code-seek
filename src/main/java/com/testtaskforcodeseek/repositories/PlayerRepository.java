package com.testtaskforcodeseek.repositories;

import com.testtaskforcodeseek.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
