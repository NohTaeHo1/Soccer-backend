package com.aws.soccer.stadium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StadiumRepository extends StadiumJPQLRepository {

//    JQPL 예시
//    @Modifying
//    @Query("update users set token = :token where id = :id")
//    public void modifyTokenById(@Param("id")Long id, @Param("token") String token);

//    11,15,16,17,23

    //11

    @Query("SELECT concat(t.region, ' ', t.team) as 팀명, s.stadiumName as 홈구장 FROM Stadium s JOIN Team t ON s.stadiumId = t.stadiumId WHERE t.region LIKE '수원%'")
    List<Map<String, Object>> teamField();

    //15

    @Query("SELECT p.playerName as 선수, p.POSITION as 포지션, CONCAT(t.region, ' ',t.team) as 팀명,s.stadiumName as 스타디움,sc.scheDate as 경기날짜" +
            " FROM Stadium s" +
            " JOIN Team t ON s.stadiumId = t.stadiumId" +
            " JOIN Player p ON t.teamId = p.teamId" +
            " JOIN Schedule sc ON s.stadiumId = sc.stadiumId" +
            " WHERE sc.scheDate = '20120317' AND p.teamId = 'K03' AND p.POSITION = 'GK'")
    List<Map<String, Object>> manyInfo();

    //16

//    @Query("SELECT DISTINCT s.stadiumName as 경기장이름, sc.scheDate as 경기일정, (select t.team FROM team t WHERE t.teamId = sc.hometeamId)as 홈팀, (select t.team FROM team t WHERE t.teamId = sc.awayteamId)as 어웨이팀" +
//            " FROM stadium s" +
//            " JOIN team t ON s.stadiumId" +
//            " JOIN player p ON t.teamId = p.teamId" +
//            " JOIN schedule sc ON s.stadiumId = sc.stadiumId" +
//            " WHERE sc.home_score - sc.away_score > 2")
//    List<String> bigWin();

    //17

    @Query("SELECT s.stadiumName as 경기장이름 , (SELECT t.team FROM Team t WHERE t.teamId = s.hometeamId) as 홈팀 FROM Stadium s ")
    List<Map<String, Object>> withNoHomeGround();

    //23

    // @Query("SELECT (SELECT s.stadiumName FROM stadium s WHERE sc.stadiumId = s.stadiumId) as 경기장 ,sc.scheDate as 경기날짜 FROM schedule sc WHERE sc.scheDate LIKE '201205%'")
    // List<String> mayStadium();
}