package com.ipl2026.ipl2026.dto.Request;

import lombok.Data;

@Data
public class PlayersRequest {

    private String playerName;
    private String teamName;
    private String teamCaptain;
    private Integer noOfMatchesPlayed;
    private Integer noOfMatchesWon;
    private Float nrr;
}
