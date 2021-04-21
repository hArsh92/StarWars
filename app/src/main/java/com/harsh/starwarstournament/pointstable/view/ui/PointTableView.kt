package com.harsh.starwarstournament.pointstable.view.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.harsh.starwarstournament.pointstable.view.model.Player
import com.harsh.starwarstournament.ui.theme.StarWarsAppTheme

@Composable fun PointsTableView(
    players: List<Player>,
    onItemClick: (Player) -> Unit
) {
    StarWarsAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            PlayerList(players = players, onItemClick = onItemClick)
        }
    }
}
