package com.ipl2026.ipl2026.controller;

import com.ipl2026.ipl2026.dto.Request.TeamRequest;
import com.ipl2026.ipl2026.entity.Team;
import com.ipl2026.ipl2026.service.TeamService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ipl")
@Data
public class TeamController {

    private final TeamService iplService;

    @PostMapping
    public String createTeam(@RequestBody TeamRequest dto){
         return iplService.createTeam(dto);
    }

    @GetMapping
    public List<Team> findAllTeams(){
        return iplService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team findTeamById(@PathVariable int id){
        return iplService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable int id){
         iplService.deleteTeam(id);
         return "Team deleted : ";
    }

    @PatchMapping("/{id}")
    public String updateTeam(@PathVariable int id, @RequestBody Team ipl2026){
        Team updatedTeam = iplService.updateTeam(id, ipl2026);
        return "Team updated : " + updatedTeam.getTeamName();
    }

    @GetMapping("/top5")
    public List<Team> findTop5Teams(){
        return iplService.Top5teams();
    }

    @GetMapping("/nrr/{nrr}")
    public List<Team> filterNrr(@PathVariable Float nrr){
        return iplService.filterByNrr(nrr);
    }

    @GetMapping("/wins/{wins}")
    public List<Team> filterWins(@PathVariable Integer wins){
        return iplService.filterByWins(wins);
    }

    @GetMapping("/matches/{matches}")
    public List<Team> filterMatches(@PathVariable Integer matches){
        return iplService.filterByMatches(matches);
    }

    @GetMapping("/best")
    public Team getBestTeam(){
        return iplService.getBestTeam();
    }

}
