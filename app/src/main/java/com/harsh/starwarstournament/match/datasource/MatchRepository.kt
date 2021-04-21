package com.harsh.starwarstournament.match.datasource

import com.harsh.starwarstournament.match.datasource.model.MatchDao
import com.harsh.starwarstournament.match.view.model.Match
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class MatchRepository @Inject constructor(
    private val matchDao: MatchDao
) {

    private val matchMapper = MatchDataMapper()

    fun getAllMatchesFor(playerId: Int): Flow<List<Match>> {
        return matchDao.getAllMatchesByPlayer(playerId = playerId)
            .flowOn(Dispatchers.IO)
            .map { matches ->
                withContext(Dispatchers.IO) {
                    matches.map { match ->
                        async {
                            val player1Name = matchDao.getPlayerNameById(match.player1Id)
                            val player2Name = matchDao.getPlayerNameById(match.player2Id)
                            matchMapper.map(
                                entity = match,
                                player1Name = player1Name,
                                player2Name = player2Name
                            )
                        }
                    }.awaitAll()
                }
            }
    }
}
