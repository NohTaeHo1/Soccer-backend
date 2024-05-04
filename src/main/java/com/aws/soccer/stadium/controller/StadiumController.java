package com.aws.soccer.stadium.controller;


import com.aws.soccer.stadium.service.StadiumServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/stadium")
@RestController
public class StadiumController {

    private final StadiumServiceImpl service;
    private final StadiumRouter router;

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchStadium(
            @RequestParam(value = "q", required = true) String q,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "hometeamId", required = false) String hometeamId
    ) {
        List<?> o = router.execute(q);
        return ResponseEntity.ok(o);
    }
}