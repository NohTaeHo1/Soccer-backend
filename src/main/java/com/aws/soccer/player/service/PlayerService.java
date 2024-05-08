package com.aws.soccer.player.service;

import com.aws.soccer.common.service.PageService;
import com.aws.soccer.player.model.Player;
import com.aws.soccer.player.model.PlayerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerService {



    Long countAllPlayer();

}