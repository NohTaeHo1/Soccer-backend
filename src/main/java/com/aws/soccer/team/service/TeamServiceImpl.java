package com.aws.soccer.team.service;

import com.aws.soccer.team.model.Team;
import com.aws.soccer.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository repository;

}
