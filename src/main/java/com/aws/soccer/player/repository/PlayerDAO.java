package com.aws.soccer.player.repository;

import com.aws.soccer.player.model.Player;
import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.player.model.QPlayerDTO;
import com.querydsl.core.annotations.QueryProjection;

import java.util.List;

public interface PlayerDAO {

    List<PlayerDTO> getAllPlayer();

    List<PlayerDTO> getAllPlayerProjections();

    List<PlayerDTO> getAllPlayerSelectFrom();

    List<PlayerDTO> getAllPlayerNoProjections();

    List<PlayerDTO> gainPositionEmpty();

    List<PlayerDTO> gainSuwonGK();
    //002
    List<PlayerDTO> gainPositionTypeEmpty();

    //003
    List<PlayerDTO> gainPositionTypeNew();

    //004
    List<PlayerDTO> gainGoalkeeperSuwon();
}
