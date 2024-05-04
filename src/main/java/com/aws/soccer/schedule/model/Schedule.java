package com.aws.soccer.schedule.model;

import com.aws.soccer.stadium.model.Stadium;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "id")
@Setter
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stadiumId;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;  
    private Long homeScore;
    private Long awayScore;

}