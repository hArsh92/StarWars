package com.harsh.starwarstournament.match.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.harsh.starwarstournament.match.datasource.MatchRepository
import com.harsh.starwarstournament.match.view.model.Match
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchListViewModel @Inject constructor(
    private val matchRepository: MatchRepository
) : ViewModel() {

    fun getMatches(playerId: Int): LiveData<List<Match>> {
        return matchRepository.getAllMatchesFor(playerId).asLiveData()
    }
}
