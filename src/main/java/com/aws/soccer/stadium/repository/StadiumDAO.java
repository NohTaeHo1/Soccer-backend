package com.aws.soccer.stadium.repository;

import com.aws.soccer.stadium.model.StadiumDTO;
import com.aws.soccer.team.model.TeamDTO;

import java.util.List;

public interface StadiumDAO {

    public List<StadiumDTO> getAllStadium();


}
