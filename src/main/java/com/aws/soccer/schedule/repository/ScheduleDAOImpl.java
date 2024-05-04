package com.aws.soccer.schedule.repository;

import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.schedule.model.QSchedule;
import com.aws.soccer.schedule.model.ScheduleDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleDAOImpl implements ScheduleDAO{

    private final JPAQueryFactory factory;

    @Override
    public List<ScheduleDTO> getAllSchedule() {
        return factory.select(
                QSchedule.schedule.id,
                QSchedule.schedule.stadiumId,
                QSchedule.schedule.scheDate,
                QSchedule.schedule.gubun,
                QSchedule.schedule.hometeamId,
                QSchedule.schedule.awayScore,
                QSchedule.schedule.homeScore,
                QSchedule.schedule.awayteamId)
                .from(QSchedule.schedule)
                .fetch()
                .stream()
                .map(tuple -> ScheduleDTO.builder()
                        .id(tuple.get(QSchedule.schedule.id))
                        .stadiumId(tuple.get(QSchedule.schedule.stadiumId))
                        .scheDate(tuple.get(QSchedule.schedule.scheDate))
                        .gubun(tuple.get(QSchedule.schedule.gubun))
                        .hometeamId(tuple.get(QSchedule.schedule.hometeamId))
                        .awayScore(tuple.get(QSchedule.schedule.awayScore))
                        .homeScore(tuple.get(QSchedule.schedule.homeScore))
                        .awayScore(tuple.get(QSchedule.schedule.awayScore))
                        .build())
                .toList();
    }
}
