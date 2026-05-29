package com.ipl2026.ipl2026.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "iplteam2026")
@Data
public class Team {

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

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Players> players = new ArrayList<>();

}
