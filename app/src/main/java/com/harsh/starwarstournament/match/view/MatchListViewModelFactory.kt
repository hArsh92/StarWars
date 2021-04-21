package com.harsh.starwarstournament.match.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harsh.starwarstournament.match.datasource.MatchRepository

class MatchListViewModelFactory(
    private val matchRepository: MatchRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatchListViewModel(matchRepository) as T
    }
}
