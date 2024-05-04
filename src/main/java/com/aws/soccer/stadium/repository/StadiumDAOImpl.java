package com.aws.soccer.stadium.repository;

import com.aws.soccer.stadium.model.QStadium;
import com.aws.soccer.stadium.model.StadiumDTO;
import com.aws.soccer.team.model.QTeam;
import com.aws.soccer.team.model.TeamDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StadiumDAOImpl implements StadiumDAO {

    private final JPAQueryFactory factory;


    @Override
    public List<StadiumDTO> getAllStadium() {
        return factory.select(
                        QStadium.stadium.id,
                        QStadium.stadium.stadiumId,
                        QStadium.stadium.stadiumName,
                        QStadium.stadium.hometeamId,
                        QStadium.stadium.seatCount,
                        QStadium.stadium.address,
                        QStadium.stadium.ddd,
                        QStadium.stadium.tel)
                .from(QStadium.stadium)
                .fetch()
                .stream()
                .map(tuple -> StadiumDTO.builder()
                        .id(tuple.get(QStadium.stadium.id))
                        .stadiumId(tuple.get(QStadium.stadium.stadiumId))
                        .stadiumName(tuple.get(QStadium.stadium.stadiumName))
                        .hometeamId(tuple.get(QStadium.stadium.hometeamId))
                        .seatCount(tuple.get(QStadium.stadium.seatCount))
                        .address(tuple.get(QStadium.stadium.address))
                        .address(tuple.get(QStadium.stadium.address))
                        .ddd(tuple.get(QStadium.stadium.ddd))
                        .tel(tuple.get(QStadium.stadium.tel))
                        .build()).toList();

    }
}
