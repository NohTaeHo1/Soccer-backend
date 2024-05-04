package com.aws.soccer.team.repository;

import com.aws.soccer.team.model.QTeam;
import com.aws.soccer.team.model.TeamDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamDAOImpl implements TeamDAO{

    private final JPAQueryFactory factory;

    @Override
    public List<TeamDTO> getAllPlayer() {
        return factory.select(
                QTeam.team1.id,
                QTeam.team1.teamId,
                QTeam.team1.team,
                QTeam.team1.region,
                QTeam.team1.eTeam,
                QTeam.team1.origYyyy,
                QTeam.team1.stadiumId,
                QTeam.team1.zipCode1,
                QTeam.team1.zipCode2,
                QTeam.team1.address,
                QTeam.team1.ddd,
                QTeam.team1.tel,
                QTeam.team1.fax,
                QTeam.team1.homepage,
                QTeam.team1.OWNER)
                .from(QTeam.team1)
                .fetch()
                .stream()
                .map(tuple -> TeamDTO.builder().id(tuple.get(QTeam.team1.id))
                        .eTeam(tuple.get(QTeam.team1.eTeam))
                        .teamId(tuple.get(QTeam.team1.teamId))
                        .team(tuple.get(QTeam.team1.team))
                        .region(tuple.get(QTeam.team1.region))
                        .eTeam(tuple.get(QTeam.team1.eTeam))
                        .origYyyy(tuple.get(QTeam.team1.origYyyy))
                        .stadiumId(tuple.get(QTeam.team1.stadiumId))
                        .zipCode1(tuple.get(QTeam.team1.zipCode1))
                        .zipCode2(tuple.get(QTeam.team1.zipCode2))
                        .address(tuple.get(QTeam.team1.address))
                        .ddd(tuple.get(QTeam.team1.ddd))
                        .tel(tuple.get(QTeam.team1.tel))
                        .fax(tuple.get(QTeam.team1.fax))
                        .homepage(tuple.get(QTeam.team1.homepage))
                        .OWNER(tuple.get(QTeam.team1.OWNER))
                        .build()).toList();
    }
}
