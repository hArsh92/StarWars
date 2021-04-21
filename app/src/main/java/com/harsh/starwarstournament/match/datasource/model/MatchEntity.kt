package com.harsh.starwarstournament.match.datasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey @ColumnInfo(name = "match_id") val match: Int,
    @ColumnInfo(name = "player1_id") val player1Id: Int,
    @ColumnInfo(name = "player1_score") val player1Score: Int,
    @ColumnInfo(name = "player2_id") val player2Id: Int,
    @ColumnInfo(name = "player2_score") val player2Score: Int
)
