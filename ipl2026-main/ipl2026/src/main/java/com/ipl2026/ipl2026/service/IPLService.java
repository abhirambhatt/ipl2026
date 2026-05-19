package com.ipl2026.ipl2026.service;

import com.ipl2026.ipl2026.entity.IPL2026;

import java.util.List;

public interface IPLService {

    IPL2026 createTeam(IPL2026 ipl2026);

    IPL2026 updateTeam(int id, IPL2026 ipl2026);

    void deleteTeam(int id);

    IPL2026 getTeam(int id);

    List<IPL2026> getAllTeams();

    List<IPL2026> filterByWins(Integer wins);

    List<IPL2026> filterByMatches(Integer matches);

    List<IPL2026> filterByNrr(Float nrr);

    IPL2026 getBestTeam();

    IPL2026 getById(int id);

    List<IPL2026> Top5teams();
}
