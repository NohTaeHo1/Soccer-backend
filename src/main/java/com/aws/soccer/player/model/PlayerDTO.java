package com.aws.soccer.player.model;


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

}