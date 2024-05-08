package com.aws.soccer.player.controller;

import com.aws.soccer.player.model.Player;
import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.player.repository.PlayerDAOImpl;
import com.aws.soccer.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlayerRouter {

    private final PlayerRepository repository;
    private final PlayerDAOImpl DAOservice;

    public List<?> execute(String type, int pageNumber, int pageSize) {

        return switch (type){
            case "1" -> repository.getDistinctPosition();
            case "2" -> repository.getPlayerNameFromSuwon();
            case "3" -> repository.getPlayersByNameAndHeight();
            case "Q5" -> repository.getplayersByCondition();
            case "5" -> repository.getSuwonGK();
            case "6" -> repository.getPlayersLimit(PageRequest.of(0, 3));
            case "01" -> DAOservice.getAllPlayer(); // 13,152,084
            case "02" -> DAOservice.getAllPlayerProjections(); // 10,554,113
            case "03" -> DAOservice.getAllPlayerStream(); // 95,588,011 ns
            case "04" -> DAOservice.getAllPlayerQPl(); // 158,781,846 ns
            case "15" -> DAOservice.gainSuwonGK();
            case "Q2" -> DAOservice.gainPositionTypeEmpty();
            case "Q3" -> DAOservice.gainPositionTypeNew();
            case "Q4" -> DAOservice.gainGoalkeeperSuwon();

            default -> null;
        };
    }
}