package com.harsh.starwarstournament.match.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.harsh.starwarstournament.datasource.orElse
import com.harsh.starwarstournament.match.view.model.Match
import com.harsh.starwarstournament.match.view.ui.PlayerMatchesEmptyView
import com.harsh.starwarstournament.match.view.ui.PlayerMatchesView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchListFragment : Fragment() {

    private val matches: MutableState<List<Match>> = mutableStateOf(emptyList())
    private val matchListViewModel: MatchListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            val playerId = arguments?.getInt(BUNDLE_PLAYER_ID).orElse { -1 }
            if (playerId != -1) {
                setContent { PlayerMatchesView(playerId = playerId, matches = matches.value) }
                matchListViewModel.getMatches(playerId = playerId)
                    .observe(requireActivity()) { matches.value = it }
            } else {
                setContent { PlayerMatchesEmptyView() }
            }
        }
    }

    companion object {
        private const val BUNDLE_PLAYER_ID = "player_id"

        fun navigationData(playerId: Int): Bundle {
            return bundleOf(
                BUNDLE_PLAYER_ID to playerId
            )
        }
    }
}