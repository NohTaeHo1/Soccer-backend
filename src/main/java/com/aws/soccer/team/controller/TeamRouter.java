package com.aws.soccer.team.controller;

import com.aws.soccer.team.repository.TeamDAO;
import com.aws.soccer.team.repository.TeamDAOImpl;
import com.aws.soccer.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class TeamRouter {

    private final TeamRepository repository;
    private final TeamDAOImpl dao;

    public List<?> execute(String type) {

        return switch (type){
            case "1"-> repository.getAllByTeamName();
            case "2"-> repository.getPlayerOrderBy();
            case "3"-> repository.getPlayerByTeamId();
            case "4" -> repository.getTeamByNoPosition();
            case "5" -> repository.getTeamByDate();
            case "6" -> repository.getTeamByHeight();
            case "0" -> dao.getAllPlayer();
            default -> null;
        };
    }
}
