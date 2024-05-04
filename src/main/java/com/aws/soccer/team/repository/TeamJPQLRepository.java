package com.aws.soccer.team.repository;

import com.aws.soccer.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TeamJPQLRepository extends JpaRepository<Team, Long> {

    @Query("SELECT new map(t as team) FROM Team t ORDER BY t.team")
    List<Map<String, Object>> getAllByTeamName(); //1

    @Query("SELECT new map(t as team) FROM Team t JOIN Player p ON t.teamId = p.teamId WHERE t.teamId IN('K02', 'K10') AND p.POSITION = 'GK' ORDER BY t.team, p.playerName")
    List<Map<String, Object>> getPlayerOrderBy(); // 10

    @Query("SELECT new map(p.height as 키, t.team as 팀명, p.playerName as 이름) FROM Team t JOIN Player p ON t.teamId = p.teamId WHERE t.teamId IN ('K02', 'K10') ORDER BY p.height, t.team, p.playerName")

    List<Map<String, Object>> getPlayerByTeamId(); // 12

    @Query("SELECT new map(t.team , p.playerName) FROM Team t JOIN Player p ON t.teamId = p.teamId WHERE p.POSITION = '' ORDER BY t.team, p.playerName")
    List<Map<String, Object>> getTeamByNoPosition(); // 13

    @Query("SELECT new map(t.team as HOME_TEAM, s.stadiumName, (SELECT t.team FROM Team t WHERE sc.awayteamId = t.teamId) as AWAY_TEAM) FROM Stadium s JOIN Schedule sc ON s.stadiumId = sc.stadiumId  JOIN Team t ON s.stadiumId = t.stadiumId WHERE sc.scheDate = '20120317'")
    List<Map<String, Object>> getTeamByDate(); // 14

    @Query("SELECT new map(t as team) FROM Team t ORDER BY t.team")
    List<Map<String, Object>> getTeamByHeight(); // 22
}