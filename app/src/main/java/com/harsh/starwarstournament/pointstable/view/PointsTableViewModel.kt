package com.harsh.starwarstournament.pointstable.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.harsh.starwarstournament.pointstable.datasource.PlayerRepository
import com.harsh.starwarstournament.pointstable.view.model.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PointsTableViewModel @Inject constructor(
    private val playerRepository: PlayerRepository
) : ViewModel() {

    fun getPlayers(): LiveData<List<Player>> {
        return playerRepository.getAllPlayers().asLiveData()
    }
}
