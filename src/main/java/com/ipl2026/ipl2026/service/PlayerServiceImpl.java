package com.ipl2026.ipl2026.service;

import com.ipl2026.ipl2026.dto.Request.PlayersRequest;
import com.ipl2026.ipl2026.entity.Players;
import com.ipl2026.ipl2026.entity.Team;
import com.ipl2026.ipl2026.repository.PlayerRepository;
import com.ipl2026.ipl2026.repository.TeamRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    public String create(PlayersRequest playersRequest) {
        Team team = teamRepository.findByTeamName(playersRequest.getTeamName());

        if (team == null) {
            return "Team not found";
        }

        Players players = new Players();

        players.setPlayerName(playersRequest.getPlayerName());
        players.setTeam(team);

        playerRepository.save(players);

        return "Player created successfully : " + players.getPlayerName();
    }


}
