package com.aws.soccer.stadium.model;

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
public class StadiumDTO {

    private Long id;
    private String stadiumId;
    private String stadiumName;
    private String hometeamId;
    private Long seatCount;
    private String address;
    private String ddd;
    private String tel;

}
