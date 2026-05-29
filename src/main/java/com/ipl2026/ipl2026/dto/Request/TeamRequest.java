package com.ipl2026.ipl2026.dto.Request;

import lombok.Data;

@Data
public class TeamRequest {

    private String teamName;
    private Integer noOfMatchesWon;
    private Integer noOfMatchesPlayed;
    private String teamCaptain;
    private Float nrr;
}
