package com.ipl2026.ipl2026.controller;

import com.ipl2026.ipl2026.dto.Request.PlayersRequest;
import com.ipl2026.ipl2026.service.PlayerService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/players")
@Data
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public String create(@RequestBody PlayersRequest playersRequest) {
       return playerService.create(playersRequest);
    }
}
