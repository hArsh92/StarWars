package com.harsh.starwarstournament.pointstable.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.harsh.starwarstournament.R
import com.harsh.starwarstournament.match.view.MatchListFragment
import com.harsh.starwarstournament.pointstable.view.model.Player
import com.harsh.starwarstournament.pointstable.view.ui.PointsTableView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PointsTableFragment : Fragment() {

    private val points: MutableState<List<Player>> = mutableStateOf(emptyList())

    private val pointsTableViewModel: PointsTableViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PointsTableView(players = points.value) { player ->
                    findNavController().navigate(
                        R.id.action_view_points_table,
                        MatchListFragment.navigationData(player.id)
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pointsTableViewModel.getPlayers()
            .observe(requireActivity()) { points.value = it }
    }
}
