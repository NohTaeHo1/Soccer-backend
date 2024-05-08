package com.aws.soccer.player.controller;


import com.aws.soccer.common.model.Box;
import com.aws.soccer.common.model.PageDTO;
import com.aws.soccer.common.service.impl.PageServiceImpl;
import com.aws.soccer.player.service.PlayerService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/players")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "dd")})
public class PlayerController {
    private final PlayerService service;
    private final PlayerRouter router;
    private final PageServiceImpl pageService;

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "q", required = true) String q,
            @RequestParam(value = "playerName", required = false) String playerName,
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "teamId", required = false) String teamId,
            Pageable pageable
    ) {
        log.info("MY-INFO : Controller searchPlayer q is {}", q);
        log.info("MY-INFO : Controller searchPlayer page is {}", pageable.getPageNumber());
        log.info("MY-INFO : Controller searchPlayer limit is {}", pageable.getPageSize());
        log.info("MY-INFO : Controller searchPlayer sortField is {}", pageable.getSort().toString());

        log.info("Controller searchPlayer q is {}", q);

        long startTime = System.nanoTime();
        List<?> o=router.execute(q, pageable.getPageNumber(), pageable.getPageSize());
        long totalCount = service.countAllPlayer();
        PageDTO page = pageService.getPageDTO(totalCount, pageable.getPageSize(), pageable.getPageNumber());

        Box box = new Box();
        box.setPageDTO(page);
        box.setList(o);

        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        return ResponseEntity.ok(box);
    }
}