package com.aws.soccer.player.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PlayerJPQLRepository<Player> {
    //Q2v
    @Query("select distinct new map (p.POSITION) from Player p")
    public List<Map<String, Object>> getDistinctPosition();
    //Q3
    @Query("select distinct case when p.POSITION = '' then '신입' else p.POSITION end from Player p")
    public List<Map<String, Object>> getDistinctByPositionIfnull();
    //Q4v
    @Query("select new map (p.playerName) from Player as p where p.teamId = 'k02' and p.POSITION = 'GK'")
    public List<Map<String, Object>> getPlayerNameFromSuwon();

    //Q5v
    @Query("select new map(p.playerName) \n" +
            " from Player as p\n" +
            " where p.teamId = 'K02' and p.playerName like '고%' and p.height >='170' \n")
    public List<Map<String, Object>> getPlayersByNameAndHeight();

    //Q6v
    @Query("select new map(p.playerName)\n" +
            "from Player p\n" +
            "where p.POSITION= 'MF'\n" +
            "and (p.height between '170' and '180')\n" +
            "and p.teamId in (select t.teamId\n" +
            "                from Team as t\n" +
            "                where t.team = '삼성블루윙즈' or t.team = '드래곤즈')")
    public List<Map<String, Object>> getplayersByCondition();

    //Q7v
    @Query("select new map(p.id, p.playerId, p.playerName," +
            " p.teamId, p.POSITION, p.height, p.weight, p.backNo, p.birthDate," +
            " p.solar, p.ePlayerName, p.nickname, p.joinYyyy, p.nation) from Player p where p.POSITION = 'GK'" +
            " and p.teamId = (select t.teamId from Team t where t.region = '수원')")
    public List<Map<String, Object>> getSuwonGK();


    ////Q18x
    @Query("select new map(p as 플레이어) from Player p")
    List<Map<String,Object>> getPlayersLimit(PageRequest pageRequest);

}