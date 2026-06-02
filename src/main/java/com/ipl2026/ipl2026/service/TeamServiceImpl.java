package com.ipl2026.ipl2026.service;

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
    public String createTeam(Team team) {
        if ((team.getNoOfMatchesWon() > team.getNoOfMatchesPlayed())) {
            throw new RuntimeException("Matches Won cannot exceed Matches Played");
        }
        teamRepository.save(team);
        return "Team Created Successfully : " + team.getTeamName();
    }

    @Override
    public Team updateTeam(Long id, Team team){
        Team ExistingTeam = getById(id);

        if (ExistingTeam == null){
            throw  new TeamNotFoundException("Team with id : " + id + "doesn't exists");
        }

        if (team.getTeamName() != null){
            ExistingTeam.setTeamName(team.getTeamName());
        }

        if (team.getTeamCaptain() != null){
            ExistingTeam.setTeamCaptain(team.getTeamCaptain());
        }

        if (team.getNoOfMatchesPlayed() != null){
            ExistingTeam.setNoOfMatchesPlayed(team.getNoOfMatchesPlayed());
        }

        if (team.getNoOfMatchesWon() != null){
            ExistingTeam.setNoOfMatchesWon(team.getNoOfMatchesWon());
        }

        if (team.getNrr() != null){
            ExistingTeam.setNrr(team.getNrr());
        }

        return teamRepository.save(ExistingTeam);
    }

    @Override
    public void deleteTeam(Long id){
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
    public Team getById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team with id : " + id + "doesn't exists"));
    }

    @Override
    public Team getTeam(Long id){
        return teamRepository.findById(id)
        .orElseThrow(() -> new TeamNotFoundException("Team not found"));
    }

    @Override
    public List<Team> Top5teams(){
        return teamRepository.findTop5ByOrderByNrrDesc();
    }


}
