package com.aws.soccer.team.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
public class TeamDTO {

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
