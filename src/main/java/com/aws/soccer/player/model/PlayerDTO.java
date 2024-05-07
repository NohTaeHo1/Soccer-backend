package com.aws.soccer.player.model;


import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Builder
@Data
@Component
public class PlayerDTO {

    private Long id;
    private String playerId;
    private String playerName;
    private String teamId;
    private String ePlayerName;
    private String nickname;
    private String joinYyyy;
    private String POSITION;
    private String backNo;
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weight;

    @QueryProjection
    public PlayerDTO(Long id, String playerId, String playerName, String teamId, String ePlayerName, String nickname, String joinYyyy, String POSITION, String backNo, String nation, String birthDate, String solar, String height, String weight) {
        this.id = id;
        this.playerId = playerId;
        this.playerName = playerName;
        this.teamId = teamId;
        this.ePlayerName = ePlayerName;
        this.nickname = nickname;
        this.joinYyyy = joinYyyy;
        this.POSITION = POSITION;
        this.backNo = backNo;
        this.nation = nation;
        this.birthDate = birthDate;
        this.solar = solar;
        this.height = height;
        this.weight = weight;
    }
}