package com.ipl2026.ipl2026.controller;

import com.ipl2026.ipl2026.entity.IPL2026;
import com.ipl2026.ipl2026.service.IPLService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ipl")
public class IPLController {

    private final IPLService iplService;

    public IPLController(IPLService iplService) {
        this.iplService = iplService;
    }

    @PostMapping
    public String createTeam(@RequestBody IPL2026 ipl2026){
          iplService.createTeam(ipl2026);
          return "Team created : " + ipl2026.getTeamName();
    }

    @GetMapping
    public List<IPL2026> findAllTeams(){
        return iplService.getAllTeams();
    }

    @GetMapping("/{id}")
    public IPL2026 findTeamById(@PathVariable int id){
        return iplService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable int id){
         iplService.deleteTeam(id);
         return "Team deleted : ";
    }

    @PatchMapping("/{id}")
    public String updateTeam(@PathVariable int id, @RequestBody IPL2026 ipl2026){
        IPL2026 updatedTeam = iplService.updateTeam(id, ipl2026);
        return "Team updated : " + updatedTeam.getTeamName();
    }

    @GetMapping("/top5")
    public List<IPL2026> findTop5Teams(){
        return iplService.Top5teams();
    }

    @GetMapping("/nrr/{nrr}")
    public List<IPL2026> filterNrr(@PathVariable Float nrr){
        return iplService.filterByNrr(nrr);
    }

    @GetMapping("/wins/{wins}")
    public List<IPL2026> filterWins(@PathVariable Integer wins){
        return iplService.filterByWins(wins);
    }

    @GetMapping("/matches/{matches}")
    public List<IPL2026> filterMatches(@PathVariable Integer matches){
        return iplService.filterByMatches(matches);
    }

    @GetMapping("/best")
    public IPL2026 getBestTeam(){
        return iplService.getBestTeam();
    }

}
