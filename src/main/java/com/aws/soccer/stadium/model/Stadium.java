package com.aws.soccer.stadium.model;


import com.aws.soccer.schedule.model.Schedule;
import com.aws.soccer.team.model.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Builder
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stadiumId;
    private String stadiumName;
    private String hometeamId;
    private Long seatCount;
    private String address;
    private String ddd;
    private String tel;

}