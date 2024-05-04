package com.aws.soccer.team.model;

import com.aws.soccer.player.model.Player;
import com.aws.soccer.stadium.model.Stadium;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamId;
    private String region;
    private String team;
    private String eTeam;
    private String origYyyy;
    private String stadiumId;
    private String zipCode1;
    private String zipCode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String OWNER;
}