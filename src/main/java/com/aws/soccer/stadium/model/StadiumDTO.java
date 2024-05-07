package com.aws.soccer.stadium.model;

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
public class StadiumDTO {

    private Long id;
    private String stadiumId;
    private String stadiumName;
    private String hometeamId;
    private Long seatCount;
    private String address;
    private String ddd;
    private String tel;

    @QueryProjection
    public StadiumDTO(Long id, String stadiumId, String stadiumName, String hometeamId, Long seatCount, String address, String ddd, String tel) {
        this.id = id;
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.hometeamId = hometeamId;
        this.seatCount = seatCount;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
    }
}
