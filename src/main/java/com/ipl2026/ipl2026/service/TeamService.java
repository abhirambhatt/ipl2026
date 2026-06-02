package com.ipl2026.ipl2026.service;

import com.ipl2026.ipl2026.entity.Team;

import java.util.List;

public interface TeamService {

    String createTeam(Team team);

    Team updateTeam(Long id, Team team);

    void deleteTeam(Long id);

    Team getTeam(Long id);

    List<Team> getAllTeams();

    List<Team> filterByWins(Integer wins);

    List<Team> filterByMatches(Integer matches);

    List<Team> filterByNrr(Float nrr);

    Team getBestTeam();

    Team getById(Long id);

    List<Team> Top5teams();
}
