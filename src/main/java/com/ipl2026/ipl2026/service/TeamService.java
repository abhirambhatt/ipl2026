package com.ipl2026.ipl2026.service;

import com.ipl2026.ipl2026.dto.Request.TeamRequest;
import com.ipl2026.ipl2026.entity.Team;

import java.util.List;

public interface TeamService {

    String createTeam(TeamRequest dto);

    Team updateTeam(int id, Team ipl2026);

    void deleteTeam(int id);

    Team getTeam(int id);

    List<Team> getAllTeams();

    List<Team> filterByWins(Integer wins);

    List<Team> filterByMatches(Integer matches);

    List<Team> filterByNrr(Float nrr);

    Team getBestTeam();

    Team getById(int id);

    List<Team> Top5teams();
}
