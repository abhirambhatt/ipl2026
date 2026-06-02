package com.ipl2026.ipl2026.service;

import com.ipl2026.ipl2026.dto.Request.PlayersRequest;
import com.ipl2026.ipl2026.entity.Players;

public interface PlayerService {

    String create(PlayersRequest playersRequest);
}
