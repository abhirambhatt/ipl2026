package com.ipl2026.ipl2026.repository;

import com.ipl2026.ipl2026.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Players, Long> {
}
