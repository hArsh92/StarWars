package com.harsh.starwarstournament.match.datasource.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {

    @Query("SELECT * FROM matches WHERE player1_id == :playerId or player2_id == :playerId")
    fun getAllMatchesByPlayer(playerId: Int): Flow<List<MatchEntity>>

    @Query("SELECT name FROM player WHERE id == :playerId")
    suspend fun getPlayerNameById(playerId: Int): String?
}
