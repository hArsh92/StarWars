package com.harsh.starwarstournament.match.view.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harsh.starwarstournament.match.view.model.Match

@Preview()
@Composable fun MatchList(playerId: Int, matches: List<Match>) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        items(items = matches) { match ->
            PlayerMatchCard(playerId = playerId, match = match)
        }
    }
}
