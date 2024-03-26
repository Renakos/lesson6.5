package com.example.lesson65.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson65.R
import com.example.lesson65.databinding.FragmentMainBinding
import com.example.lesson65.ui.adapter.RickAndMortyAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private var rickAndMortyAdapter = RickAndMortyAdapter()
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeLiveData()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = rickAndMortyAdapter
    }

    private fun observeLiveData() = with(viewModel) {
        locationCharacterState.observe(viewLifecycleOwner) { data ->
            rickAndMortyAdapter.submitList(data)
        }
    }
}
