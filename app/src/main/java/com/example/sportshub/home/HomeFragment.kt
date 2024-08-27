package com.example.sportshub.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportshub.R
import com.example.sportshub.core.data.source.Resource
import com.example.sportshub.core.domain.model.Sport
import com.example.sportshub.core.ui.SportAdapter
import com.example.sportshub.databinding.FragmentHomeBinding
import com.example.sportshub.detail.DetailSportActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val sportAdapter = SportAdapter()
            sportAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailSportActivity::class.java)
                intent.putExtra(DetailSportActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            with(binding.rvTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = sportAdapter
            }

            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (!query.isNullOrEmpty()) {
                        val (sport, country) = parseQuery(query)
                        searchTeam(sport, country, sportAdapter)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })

            val (defaultSport, defaultCountry) = parseQuery("Soccer Spain")
            searchTeam(defaultSport, defaultCountry, sportAdapter)
        }
    }

    private fun searchTeam(sport: String, country: String, adapter: SportAdapter) {
        homeViewModel.getSports(sport, country).observe(viewLifecycleOwner) { sportResource: Resource<List<Sport>>? ->
            if (sportResource != null) {
                when (sportResource) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.setData(sportResource.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            sportResource.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        }
    }

    private fun parseQuery(query: String): Pair<String, String> {
        val parts = query.split(" ")
        return if (parts.size >= 2) {
            Pair(parts[0], parts[1])
        } else {
            Pair("Soccer", "Spain")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
