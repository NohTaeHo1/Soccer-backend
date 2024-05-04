package com.aws.soccer.player.repository;

import com.aws.soccer.player.model.Player;
import com.aws.soccer.player.model.PlayerDTO;
import com.aws.soccer.player.model.QPlayer;
import com.aws.soccer.player.service.PlayerService;
import com.aws.soccer.player.service.PlayerServiceImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerDAOImpl implements PlayerDAO {
    // 클래스에 @PersistenceContext 해주면 -> 클래스이름을 첫문자 소문자로 key, 각 메서드 이름을 값으로 생성해놓음

    private final JPAQueryFactory factory;


    @Override
    public List<PlayerDTO> getAllPlayer() {
        return factory.select(
                        QPlayer.player.id,
                        QPlayer.player.playerId,
                        QPlayer.player.playerName,
                        QPlayer.player.teamId,
                        QPlayer.player.ePlayerName,
                        QPlayer.player.nickname,
                        QPlayer.player.joinYyyy,
                        QPlayer.player.POSITION,
                        QPlayer.player.backNo,
                        QPlayer.player.nation,
                        QPlayer.player.birthDate,
                        QPlayer.player.solar,
                        QPlayer.player.height,
                        QPlayer.player.weight)
                .from(QPlayer.player)
                .fetch()
                .stream()
                .map(tuple -> PlayerDTO.builder()
                        .id(tuple.get(QPlayer.player.id))
                        .playerId(tuple.get(QPlayer.player.playerId))
                        .playerName(tuple.get(QPlayer.player.playerName))
                        .teamId(tuple.get(QPlayer.player.teamId))
                        .ePlayerName(tuple.get(QPlayer.player.ePlayerName))
                        .nickname(tuple.get(QPlayer.player.nickname))
                        .joinYyyy(tuple.get(QPlayer.player.joinYyyy))
                        .POSITION(tuple.get(QPlayer.player.POSITION))
                        .backNo(tuple.get(QPlayer.player.backNo))
                        .nation(tuple.get(QPlayer.player.nation))
                        .birthDate(tuple.get(QPlayer.player.birthDate))
                        .solar(tuple.get(QPlayer.player.solar))
                        .height(tuple.get(QPlayer.player.height))
                        .weight(tuple.get(QPlayer.player.weight))
                        .build())
                .toList();
    }
@Override
public List<PlayerDTO> getAllPlayerProjections() {
    return factory.select(Projections.constructor(PlayerDTO.class,
                    QPlayer.player.id,
                    QPlayer.player.playerId,
                    QPlayer.player.playerName,
                    QPlayer.player.teamId,
                    QPlayer.player.ePlayerName,
                    QPlayer.player.nickname,
                    QPlayer.player.joinYyyy,
                    QPlayer.player.POSITION,
                    QPlayer.player.backNo,
                    QPlayer.player.nation,
                    QPlayer.player.birthDate,
                    QPlayer.player.solar,
                    QPlayer.player.height,
                    QPlayer.player.weight))
            .from(QPlayer.player)
            .fetch();
    }

    @Override
    public List<PlayerDTO> getAllPlayerSelectFrom() {
        return factory.selectFrom(QPlayer.player)
                .fetch()
                .stream()
                .map(this::entityToDTO)
                .toList();

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
