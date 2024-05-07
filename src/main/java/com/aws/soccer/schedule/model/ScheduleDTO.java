package com.aws.soccer.schedule.model;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Builder
@Data
@Component
public class ScheduleDTO {

    private Long id;
    private String stadiumId;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private Long homeScore;
    private Long awayScore;

    @QueryProjection
    public ScheduleDTO(Long id, String stadiumId, String scheDate, String gubun, String hometeamId, String awayteamId, Long homeScore, Long awayScore) {
        this.id = id;
        this.stadiumId = stadiumId;
        this.scheDate = scheDate;
        this.gubun = gubun;
        this.hometeamId = hometeamId;
        this.awayteamId = awayteamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}