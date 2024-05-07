package com.aws.soccer.team.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


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

    @QueryProjection
    public TeamDTO(Long id, String teamId, String region, String team, String eTeam, String origYyyy, String stadiumId, String zipCode1, String zipCode2, String address, String ddd, String tel, String fax, String homepage, String OWNER) {
        this.id = id;
        this.teamId = teamId;
        this.region = region;
        this.team = team;
        this.eTeam = eTeam;
        this.origYyyy = origYyyy;
        this.stadiumId = stadiumId;
        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
        this.fax = fax;
        this.homepage = homepage;
        this.OWNER = OWNER;
    }
}
