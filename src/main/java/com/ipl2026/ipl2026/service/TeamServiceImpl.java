package com.ipl2026.ipl2026.service;

import com.ipl2026.ipl2026.dto.Request.TeamRequest;
import com.ipl2026.ipl2026.entity.Team;
import com.ipl2026.ipl2026.exception.TeamNotFoundException;
import com.ipl2026.ipl2026.repository.TeamRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Data
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public String createTeam(TeamRequest dto) {

        Team team = new Team();

        team.setTeamName(dto.getTeamName());

        team.setNoOfMatchesPlayed(
                dto.getNoOfMatchesPlayed()
        );

        team.setNoOfMatchesWon(
                dto.getNoOfMatchesWon()
        );

        team.setNrr(dto.getNrr());

        team.setTeamCaptain(
                dto.getTeamCaptain()
        );

        teamRepository.save(team);

        return "Team Created Successfully : " + team.getTeamName();
    }

    @Override
    public Team updateTeam(int id, Team ipl2026){
        Team ExistingTeam = getById(id);

        if (ExistingTeam == null){
            throw  new TeamNotFoundException("Team with id : " + id + "doesn't exists");
        }

        if (ipl2026.getTeamName() != null){
            ExistingTeam.setTeamName(ipl2026.getTeamName());
        }

        if (ipl2026.getTeamCaptain() != null){
            ExistingTeam.setTeamCaptain(ipl2026.getTeamCaptain());
        }

        if (ipl2026.getNoOfMatchesPlayed() != null){
            ExistingTeam.setNoOfMatchesPlayed(ipl2026.getNoOfMatchesPlayed());
        }

        if (ipl2026.getNoOfMatchesWon() != null){
            ExistingTeam.setNoOfMatchesWon(ipl2026.getNoOfMatchesWon());
        }

        if (ipl2026.getNrr() != null){
            ExistingTeam.setNrr(ipl2026.getNrr());
        }

        return teamRepository.save(ExistingTeam);
    }

    @Override
    public void deleteTeam(int id){
        Team ipl2026 = teamRepository.findById(id)
                        .orElseThrow(() -> new TeamNotFoundException("Team with id : " + id + "doesn't exists"));
        teamRepository.delete(ipl2026);
    }

    @Override
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @Override
    public List<Team> filterByWins(Integer wins) {
        return teamRepository.findByNoOfMatchesWonGreaterThan(wins);
    }

    @Override
    public List<Team> filterByMatches(Integer matches) {
        return teamRepository.findByNoOfMatchesPlayedGreaterThan(matches);
    }

    @Override
    public List<Team> filterByNrr(Float nrr) {
        return teamRepository.findByNrrGreaterThan(nrr);
    }

    @Override
    public Team getBestTeam() {
        return teamRepository.findAll()
                .stream()
                .max(Comparator.comparingInt(Team::getNoOfMatchesWon))
                .orElseThrow(() -> new TeamNotFoundException("No Teams were found"));
    }

    @Override
    public Team getById(int id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team with id : " + id + "doesn't exists"));
    }

    @Override
    public Team getTeam(int id){
        return teamRepository.findById(id)
        .orElseThrow(() -> new TeamNotFoundException("Team not found"));
    }

    @Override
    public List<Team> Top5teams(){
        return teamRepository.findTop5ByOrderByNrrDesc();
    }


}
