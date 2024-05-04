package com.aws.soccer.team.repository;

import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.team.model.TeamDTO;

import java.util.List;

public interface TeamDAO {

    public List<TeamDTO> getAllPlayer();
}
