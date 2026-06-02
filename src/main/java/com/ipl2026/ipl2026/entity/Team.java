package com.ipl2026.ipl2026.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "iplteam2026")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Team name cannot be empty")
    @Column(name = "Team_Name",  nullable = false)
    private String teamName;

    @NotBlank(message = "Team Captain cannot be empty")
    @Column(name = "Team_Captain",  nullable = false)
    private String teamCaptain;

    @Min(value = 0, message = "Matches Played cannot be empty or negative")
    @Column(name = "No_of_Matches_played")
    private Integer noOfMatchesPlayed;

    @Min(value = 0, message = "Matches Won cannot be empty or negative")
    @Column(name = "No_of_matches_won")
    private Integer noOfMatchesWon;

    @DecimalMin(value = "-10.00", message = "NRR too low")
    @DecimalMax(value = "10.00", message = "NRR too high")
    @Column(name = "NRR")
    private Float nrr;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Players> players;

}
