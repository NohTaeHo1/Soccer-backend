package com.aws.soccer.stadium.controller;

import com.aws.soccer.stadium.repository.StadiumDAOImpl;
import com.aws.soccer.stadium.repository.StadiumJPQLRepository;
import com.aws.soccer.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class StadiumRouter {

    private final StadiumRepository repository;
    private final StadiumDAOImpl service;

    public List<?> execute(String i) {
        return switch (i) {
            case "1" -> repository.teamField();
            case "2" -> repository.manyInfo();
            case "3" -> repository.withNoHomeGround();
            case "0" -> service.getAllStadium();
            default -> null;
        };
    }
}
