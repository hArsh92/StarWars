package com.harsh.starwarstournament.match.view.model

data class Match(
    val matchId: Int,
    val player1: PlayerScore,
    val player2: PlayerScore
)

data class PlayerScore(
    val playerId: Int,
    val playerName: String,
    val score: Int
)
