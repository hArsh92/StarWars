package com.harsh.starwarstournament.pointstable.datasource

import com.harsh.starwarstournament.pointstable.datasource.model.PlayerDao
import com.harsh.starwarstournament.pointstable.view.model.Player
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class PlayerRepository @Inject constructor(
    private val pointsTableDao: PlayerDao
) {

    private val playerMapper = PlayerDataMapper()

    fun getAllPlayers(): Flow<List<Player>> {
        return pointsTableDao.getAllPlayers()
            .flowOn(Dispatchers.IO)
            .map { players ->
                withContext(Dispatchers.IO) {
                    players.map { player ->
                        async {
                            val playerScore = pointsTableDao.getPlayerPoints(player.id)
                            playerMapper.map(player, playerScore)
                        }
                    }.awaitAll().sortedByDescending { it.points }
                }
            }
    }
}
