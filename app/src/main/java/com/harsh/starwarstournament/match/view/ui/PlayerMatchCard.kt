package com.harsh.starwarstournament.match.view.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.harsh.starwarstournament.match.view.model.Match
import com.harsh.starwarstournament.ui.theme.HoloGreenLight
import com.harsh.starwarstournament.ui.theme.HoloRedLight
import com.harsh.starwarstournament.ui.theme.Typography

@Composable fun PlayerMatchCard(playerId: Int, match: Match) {
    val backgroundColor = remember(match) { getBackgroundColor(playerId, match) }
    Card(
        backgroundColor = backgroundColor,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(
                    text = match.player1.playerName,
                    style = Typography.body1,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = match.player1.score.toString())
            }

            Row {
                Text(text = match.player2.score.toString())
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = match.player2.playerName,
                    style = Typography.body1,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}

private fun getBackgroundColor(playerId: Int, match: Match): Color {
    return when(playerId) {
        match.player1.playerId -> when {
            match.player1.score > match.player2.score -> HoloGreenLight
            match.player1.score < match.player2.score -> HoloRedLight
            else -> Color.White
        }
        match.player2.playerId -> when {
            match.player2.score > match.player1.score -> HoloGreenLight
            match.player2.score < match.player1.score -> HoloRedLight
            else -> Color.White
        }
        else -> Color.White
    }
}
