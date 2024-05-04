package com.aws.soccer.schedule.controller;

import com.aws.soccer.schedule.repository.ScheduleDAOImpl;
import com.aws.soccer.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class ScheduleRouter {

    private final ScheduleRepository repository;
    private final ScheduleDAOImpl service;

    public List<?> execute(String i){

        return switch (i){
            case "1" -> repository.findStadiumNamesByDateRange();
            case "2" -> repository.mayStadium();
            case "0" -> service.getAllSchedule();
            default -> null;
        };
    }


}
