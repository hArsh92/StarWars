package com.harsh.starwarstournament.pointstable.datasource

import com.harsh.starwarstournament.pointstable.datasource.model.PlayerEntity
import com.harsh.starwarstournament.pointstable.view.model.Player

class PlayerDataMapper {

    fun map(entity: PlayerEntity, score: Int): Player {
        return Player(
            id = entity.id,
            name = entity.name,
            image = entity.icon,
            points = score
        )
    }
}
