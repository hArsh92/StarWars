package com.harsh.starwarstournament.match.view.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.harsh.starwarstournament.match.view.model.Match
import com.harsh.starwarstournament.ui.theme.StarWarsAppTheme

@Composable
fun PlayerMatchesView(playerId: Int, matches: List<Match>) {
    StarWarsAppTheme {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxHeight()) {
            MatchList(playerId = playerId, matches = matches)
        }
    }
}

@Composable fun PlayerMatchesEmptyView() {
    StarWarsAppTheme {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxHeight()) {
            Column(modifier = Modifier.fillMaxHeight()) {
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Unable to find matches for the selected player",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
