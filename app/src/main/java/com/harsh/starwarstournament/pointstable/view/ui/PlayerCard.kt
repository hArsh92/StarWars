package com.harsh.starwarstournament.pointstable.view.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.imageloading.MaterialLoadingImage
import com.harsh.starwarstournament.R
import com.harsh.starwarstournament.pointstable.view.model.Player
import com.harsh.starwarstournament.ui.theme.Typography

@Composable fun PlayerCard(
    player: Player,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            CoilImage(
                data = player.image,
                content = loadImage(contentDescription = "${player.name}'s Image"),
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = player.name,
                style = Typography.body1,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Text(
            text = player.points.toString(),
            style = Typography.h6,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

private fun loadImage(contentDescription: String): @Composable (BoxScope.(imageLoadState: ImageLoadState) -> Unit) =
    { imageState ->
        when (imageState) {
            is ImageLoadState.Success -> {
                MaterialLoadingImage(
                    result = imageState,
                    contentDescription = contentDescription,
                    fadeInEnabled = true,
                    fadeInDurationMs = 600,
                    contentScale = ContentScale.Crop,
                )
            }
            is ImageLoadState.Error,
            is ImageLoadState.Empty -> {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = contentDescription
                )
            }
            is ImageLoadState.Loading -> {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        }
    }
