package com.aws.soccer.player.repository;

import com.aws.soccer.player.model.Player;
import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.player.model.QPlayer;
import com.aws.soccer.player.model.QPlayerDTO;
import com.aws.soccer.team.model.QTeam;
import com.aws.soccer.team.model.QTeamDTO;
import com.aws.soccer.team.model.TeamDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerDAOImpl implements PlayerDAO {
    // 클래스에 @PersistenceContext 해주면 -> 클래스이름을 첫문자 소문자로 key, 각 메서드 이름을 값으로 생성해놓음

    private final JPAQueryFactory factory;
    // EntityManager과 같은 처리를 하는 DSL 프레임워크쪽 객체

    private final QPlayer player = QPlayer.player;

    private final TeamDTO teamDTO;


    @Override
    public List<PlayerDTO> getAllPlayer() {
        return factory.select(
                        player.id,
                        player.playerId,
                        player.playerName,
                        player.teamId,
                        player.ePlayerName,
                        player.nickname,
                        player.joinYyyy,
                        player.POSITION,
                        player.backNo,
                        player.nation,
                        player.birthDate,
                        player.solar,
                        player.height,
                        player.weight)
                .from(player)
                .fetch()
                .stream()
                .map(tuple -> PlayerDTO.builder()
                        .id(tuple.get(player.id))
                        .playerId(tuple.get(player.playerId))
                        .playerName(tuple.get(player.playerName))
                        .teamId(tuple.get(player.teamId))
                        .ePlayerName(tuple.get(player.ePlayerName))
                        .nickname(tuple.get(player.nickname))
                        .joinYyyy(tuple.get(player.joinYyyy))
                        .POSITION(tuple.get(player.POSITION))
                        .backNo(tuple.get(player.backNo))
                        .nation(tuple.get(player.nation))
                        .birthDate(tuple.get(player.birthDate))
                        .solar(tuple.get(player.solar))
                        .height(tuple.get(player.height))
                        .weight(tuple.get(player.weight))
                        .build())
                .toList();
    }

    @Override
    public List<PlayerDTO> getAllPlayerProjections() { // 17,048,371 ns
        return factory.select(Projections.constructor(PlayerDTO.class,
                        player.id,
                        player.playerId,
                        player.playerName,
                        player.teamId,
                        player.ePlayerName,
                        player.nickname,
                        player.joinYyyy,
                        player.POSITION,
                        player.backNo,
                        player.nation,
                        player.birthDate,
                        player.solar,
                        player.height,
                        player.weight))
                .from(player)
                .fetch();
    }

    @Override
    public List<PlayerDTO> getAllPlayerSelectFrom() { // 90,682,459 ns
        return factory.selectFrom(player)
                .fetch()
                .stream()
                .map(this::entityToDTO)
                .toList();
    }

    @Override
    public List<PlayerDTO> getAllPlayerNoProjections() {
        return factory.select(
                        new QPlayerDTO(
                                player.id,
                                player.playerId,
                                player.playerName,
                                player.teamId,
                                player.ePlayerName,
                                player.nickname,
                                player.joinYyyy,
                                player.POSITION,
                                player.backNo,
                                player.nation,
                                player.birthDate,
                                player.solar,
                                player.height,
                                player.weight))
                .from(player)
                .fetch();
    }

    //002
    public List<PlayerDTO> gainPositionTypeEmpty(){
        return factory.selectDistinct(Projections.constructor(PlayerDTO.class, player.POSITION))
                .from(player)
                .fetch();
    }

    //003
    public List<PlayerDTO> gainPositionTypeNew(){
        return factory.selectDistinct(Projections.constructor(PlayerDTO.class, player.POSITION.coalesce("신입").nullif("").as("포지션")))
                .from(player)
                .fetch();
    }

    //004
    public List<PlayerDTO> gainGoalkeeperSuwon(){
        return factory.select(Projections.constructor(PlayerDTO.class, player.playerName))
                .from(player)
                .where(player.POSITION.eq("GK").and(player.teamId.eq("K02")))
                .fetch();
    }


    public List<PlayerDTO> gainPositionEmpty() {
        return factory.selectDistinct(
                        new QPlayerDTO(
                                player.id,
                                player.playerId,
                                player.playerName,
                                player.teamId,
                                player.ePlayerName,
                                player.nickname,
                                player.joinYyyy,
                                player.POSITION,
                                player.backNo,
                                player.nation,
                                player.birthDate,
                                player.solar,
                                player.height,
                                player.weight)
                ).from(player)
                .orderBy(player.playerName.asc())
                .offset(1)
                .limit(5)
                .fetch();
    }

    public List<PlayerDTO> gainPlayerNameFromSuwon() {
        return factory.select(player.playerName)
                .from(player)
                .where(player.teamId.eq("k02").and(player.POSITION.eq("GK")))
                .fetch()
                .stream()
                .map(i -> PlayerDTO.builder().playerName(i).build())
                .toList();
    }

    public List<QPlayerDTO> gainPlayersByNameAndHeight() { // 17,048,371 ns
        return factory.select(Projections.constructor(QPlayerDTO.class,
                        player.playerName
                ))
                .from(player)
                .where(player.teamId.eq("K02").and(player.playerName.like("고%").and(player.height.castToNum(Integer.class).goe(170))))
                .fetch();
    }

    public List<QPlayerDTO> gainPlayersByCondition() { // 17,048,371 ns
        return factory.select(Projections.constructor(QPlayerDTO.class,
                        player.playerName
                ))
                .from(player)
                .where(player.POSITION.eq("MF").and(player.height.castToNum(Integer.class).between(170, 180)).and(player.teamId.in(JPAExpressions.select(QTeam.team1.teamId).from(QTeam.team1)
                        .where(QTeam.team1.team.eq("삼성블루윙즈").or(QTeam.team1.team.eq("드래곤즈"))))))
                .fetch();
    }

    public List<PlayerDTO> gainSuwonGK() {
        return factory.selectDistinct(
                        new QPlayerDTO(
                                player.id,
                                player.playerId,
                                player.playerName,
                                player.teamId,
                                player.ePlayerName,
                                player.nickname,
                                player.joinYyyy,
                                player.POSITION,
                                player.backNo,
                                player.nation,
                                player.birthDate,
                                player.solar,
                                player.height,
                                player.weight)
                ).from(player)
                .where(player.POSITION.eq("GK").and(player.teamId.eq(JPAExpressions.select(QTeam.team1.teamId).from(player)
                        .where(QTeam.team1.region.eq("수원")))))
                .fetch();
    }






    public PlayerDTO entityToDTO(Player entity) {
        return PlayerDTO.builder()
                .id(entity.getId())
                .playerId(entity.getPlayerId())
                .playerName(entity.getPlayerName())
                .teamId(entity.getTeamId())
                .ePlayerName(entity.getPlayerName())
                .nickname(entity.getNickname())
                .joinYyyy(entity.getJoinYyyy())
                .POSITION(entity.getPOSITION())
                .backNo(entity.getBackNo())
                .nation(entity.getNation())
                .birthDate(entity.getBirthDate())
                .solar(entity.getSolar())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .build();

    }

}
