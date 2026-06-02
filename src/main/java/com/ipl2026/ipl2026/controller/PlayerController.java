package com.ipl2026.ipl2026.controller;

import com.ipl2026.ipl2026.dto.Request.PlayersRequest;
import com.ipl2026.ipl2026.service.PlayerService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
@Data
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public String create(@Valid @RequestBody PlayersRequest playersRequest) {
       return playerService.create(playersRequest);
    }
}
