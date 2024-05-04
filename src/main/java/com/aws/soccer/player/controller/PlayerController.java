package com.aws.soccer.player.controller;


import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.player.service.PlayerService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/player")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "dd")})
public class PlayerController {
    private final PlayerService playerservice;
    private final PlayerRouter router;

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "q", required = true) String q,
            @RequestParam(value = "playerName", required = false) String playerName,
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "teamId", required = false) String teamId
    ) {
        log.info("Controller searchPlayer q is {}", q);
        long startTime = System.nanoTime();
        List<?> o=router.execute(q);
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        return ResponseEntity.ok(o);
    }

}