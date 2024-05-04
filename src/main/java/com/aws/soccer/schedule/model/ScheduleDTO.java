package com.aws.soccer.schedule.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
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

}