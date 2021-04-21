package com.harsh.starwarstournament.pointstable.datasource.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun getAllPlayers(): Flow<List<PlayerEntity>>

    @Query(
        """
        SELECT COUNT(*) FROM matches WHERE 
        (player1_id == :playerId AND player1_score >= player2_score)
        OR
        (player2_id == :playerId AND player2_score >= player1_score)
        """
    )
    suspend fun getPlayerPoints(playerId: Int): Int
}
