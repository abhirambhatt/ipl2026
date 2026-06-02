package com.ipl2026.ipl2026.repository;

import com.ipl2026.ipl2026.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {


    List<Team> findTop5ByOrderByNrrDesc();

    List<Team> findByNrrGreaterThan(Float nrr);

    List<Team> findByNoOfMatchesWonGreaterThan(Integer wins);

    List<Team> findByNoOfMatchesPlayedGreaterThan(Integer matches);

    Team findByTeamName(String teamName);

}
