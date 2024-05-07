package com.aws.soccer.team.repository;

import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.player.model.QPlayerDTO;
import com.aws.soccer.team.model.QTeam;
import com.aws.soccer.team.model.QTeamDTO;
import com.aws.soccer.team.model.TeamDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamDAOImpl implements TeamDAO{

    private final JPAQueryFactory factory;
    private final QTeam team = QTeam.team1;
    

    @Override
    public List<TeamDTO> gainAllTeam() {
        return factory.select(
                team.id,
                team.teamId,
                team.team,
                team.region,
                team.eTeam,
                team.origYyyy,
                team.stadiumId,
                team.zipCode1,
                team.zipCode2,
                team.address,
                team.ddd,
                team.tel,
                team.fax,
                team.homepage,
                team.OWNER)
                .from(team)
                .fetch()
                .stream()
                .map(tuple -> TeamDTO.builder().id(tuple.get(team.id))
                        .eTeam(tuple.get(team.eTeam))
                        .teamId(tuple.get(team.teamId))
                        .team(tuple.get(team.team))
                        .region(tuple.get(team.region))
                        .eTeam(tuple.get(team.eTeam))
                        .origYyyy(tuple.get(team.origYyyy))
                        .stadiumId(tuple.get(team.stadiumId))
                        .zipCode1(tuple.get(team.zipCode1))
                        .zipCode2(tuple.get(team.zipCode2))
                        .address(tuple.get(team.address))
                        .ddd(tuple.get(team.ddd))
                        .tel(tuple.get(team.tel))
                        .fax(tuple.get(team.fax))
                        .homepage(tuple.get(team.homepage))
                        .OWNER(tuple.get(team.OWNER))
                        .build()).toList();
    }

    //001
    @Override
    public List<TeamDTO> gainAllTeamASC() {
        return factory.select(
                        new QTeamDTO(
                                team.id,
                                team.teamId,
                                team.team,
                                team.region,
                                team.eTeam,
                                team.origYyyy,
                                team.stadiumId,
                                team.zipCode1,
                                team.zipCode2,
                                team.address,
                                team.ddd,
                                team.tel,
                                team.fax,
                                team.homepage,
                                team.OWNER))
                .from(team)
                .fetch();
    }


}
