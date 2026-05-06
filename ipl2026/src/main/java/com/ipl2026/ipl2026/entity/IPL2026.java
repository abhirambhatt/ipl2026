package com.ipl2026.ipl2026.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "iplteam2026")
public class IPL2026 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Team_Name")
    private String teamName;

    @Column(name = "Team_Captain")
    private String teamCaptain;

    @Column(name = "No_of_Matches_played")
    private Integer noOfMatchesPlayed;

    @Column(name = "No_of_matches_won")
    private Integer noOfMatchesWon;

    @Column(name = "NRR")
    private Float nrr;

    public IPL2026() {}

    public IPL2026(String teamName, String teamCaptain, Integer noOfMatchesPlayed, Integer noOfMatchesWon, Float nrr) {
        this.teamName = teamName;
        this.teamCaptain = teamCaptain;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
        this.noOfMatchesWon = noOfMatchesWon;
        this.nrr = nrr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public Integer getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(Integer noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public Integer getNoOfMatchesWon() {
        return noOfMatchesWon;
    }

    public void setNoOfMatchesWon(Integer noOfMatchesWon) {
        this.noOfMatchesWon = noOfMatchesWon;
    }

    public Float getNrr() {
        return nrr;
    }

    public void setNrr(Float nrr) {
        this.nrr = nrr;
    }

}
