package com.aws.soccer.stadium.repository;

import com.aws.soccer.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface StadiumJPQLRepository extends JpaRepository<Stadium, Long> {

    @Query("SELECT new map(concat(t.region, ' ', t.team) as 팀명, s.stadiumName as 홈구장) FROM Stadium s JOIN Team t ON s.stadiumId = t.stadiumId WHERE t.region LIKE '수원%'")
    List<Map<String, Object>> teamField();

    //15

    @Query("SELECT new map (p.playerName as 선수, p.POSITION as 포지션, CONCAT(t.region, ' ',t.team) as 팀명,s.stadiumName as 스타디움,sc.scheDate as 경기날짜)" +
            " FROM Stadium s" +
            " JOIN Team t ON s.stadiumId = t.stadiumId" +
            " JOIN Player p ON t.teamId = p.teamId" +
            " JOIN Schedule sc ON s.stadiumId = sc.stadiumId" +
            " WHERE sc.scheDate = '20120317' AND p.teamId = 'K03' AND p.POSITION = 'GK'")
    List<Map<String, Object>> manyInfo();

    //16

    @Query("SELECT new map(s.stadiumName as 경기장이름 , (SELECT t.team FROM Team t WHERE t.teamId = s.hometeamId) as 홈팀) FROM Stadium s ")
    List<Map<String, Object>> withNoHomeGround();

}
