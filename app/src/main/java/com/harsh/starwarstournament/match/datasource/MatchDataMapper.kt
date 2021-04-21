package com.harsh.starwarstournament.match.datasource

import com.harsh.starwarstournament.match.datasource.model.MatchEntity
import com.harsh.starwarstournament.match.view.model.Match
import com.harsh.starwarstournament.match.view.model.PlayerScore

class MatchDataMapper {

    fun map(
        entity: MatchEntity,
        player1Name: String?,
        player2Name: String?
    ): Match {
        return Match(
            matchId = entity.match,
            player1 = PlayerScore(
                playerId = entity.player1Id,
                playerName = player1Name.orEmpty(),
                score = entity.player1Score
            ),
            player2 = PlayerScore(
                playerId = entity.player2Id,
                playerName = player2Name.orEmpty(),
                score = entity.player2Score
            )
        )
    }
}
