package com.aws.soccer.player.service;

import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;

}