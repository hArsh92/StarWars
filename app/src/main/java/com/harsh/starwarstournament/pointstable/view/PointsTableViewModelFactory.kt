package com.harsh.starwarstournament.pointstable.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harsh.starwarstournament.pointstable.datasource.PlayerRepository

class PointsTableViewModelFactory(
    private val playerRepository: PlayerRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PointsTableViewModel(playerRepository) as T
    }
}
