package com.aws.soccer.schedule.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aws.soccer.schedule.service.ScheduleService;
import com.aws.soccer.schedule.service.ScheduleServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/schedule")
@RestController
public class ScheduleController {

    private final ScheduleServiceImpl scheduleService;
    private final ScheduleRouter router;


    @GetMapping(path= "/search")
    public ResponseEntity<?> serachSchedule(
            @RequestParam(value = "q", required = true) String q,
            @RequestParam(value = "stadiumId", required = false) String stadiumId,
            @RequestParam(value = "scheDate", required = false) String scheDate,
            @RequestParam(value = "gubun", required = false) String gubun
    ){
        List<?> o = router.execute(q);
        return ResponseEntity.ok(o);
    }

    

    
    
}
