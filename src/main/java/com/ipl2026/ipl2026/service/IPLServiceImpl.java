package com.ipl2026.ipl2026.service;

import com.ipl2026.ipl2026.entity.IPL2026;
import com.ipl2026.ipl2026.exception.TeamNotFoundException;
import com.ipl2026.ipl2026.repository.IPLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class IPLServiceImpl implements IPLService {

    private final IPLRepository repository;

    @Autowired
    public IPLServiceImpl(IPLRepository repository) {
        this.repository = repository;
    }

    @Override
    public IPL2026 createTeam(IPL2026 ipl2026){
         repository.save(ipl2026);
        return ipl2026;
    }

    @Override
    public IPL2026 updateTeam(int id, IPL2026 ipl2026){
        IPL2026 ExistingTeam = getById(id);

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

        return repository.save(ExistingTeam);
    }

    @Override
    public void deleteTeam(int id){
        IPL2026 ipl2026 = repository.findById(id)
                        .orElseThrow(() -> new TeamNotFoundException("Team with id : " + id + "doesn't exists"));
        repository.delete(ipl2026);
    }

    @Override
    public List<IPL2026> getAllTeams(){
        return repository.findAll();
    }

    @Override
    public List<IPL2026> filterByWins(Integer wins) {
        return repository.findByNoOfMatchesWonGreaterThan(wins);
    }

    @Override
    public List<IPL2026> filterByMatches(Integer matches) {
        return repository.findByNoOfMatchesPlayedGreaterThan(matches);
    }

    @Override
    public List<IPL2026> filterByNrr(Float nrr) {
        return repository.findByNrrGreaterThan(nrr);
    }

    @Override
    public IPL2026 getBestTeam() {
        return repository.findAll()
                .stream()
                .max(Comparator.comparingInt(IPL2026::getNoOfMatchesWon))
                .orElseThrow(() -> new TeamNotFoundException("No Teams were found"));
    }

    @Override
    public IPL2026 getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team with id : " + id + "doesn't exists"));
    }

    @Override
    public IPL2026 getTeam(int id){
        return repository.findById(id)
        .orElseThrow(() -> new TeamNotFoundException("Team not found"));
    }

    @Override
    public List<IPL2026> Top5teams(){
        return repository.findTop5ByOrderByNrrDesc();
    }


}
