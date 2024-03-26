package com.example.lesson65.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson65.data.remote.mainmodel.CharacterAndLocationModel
import com.example.lesson65.databinding.ItemCharacterBinding

class RickAndMortyAdapter :
    ListAdapter<CharacterAndLocationModel, RickAndMortyAdapter.RickAndMortyViewHolder>(
        DiffUtilCallback()
    ) {

    class RickAndMortyViewHolder(private val binding: ItemCharacterBinding) :
        ViewHolder(binding.root) {
        fun onBind(get: CharacterAndLocationModel) = with(binding) {
            characterNameTextView.text = get.name
            characterSpeciesTextView.text = get.species
            characterLocationTextView.text = get.location
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        return RickAndMortyViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<CharacterAndLocationModel>() {

            override fun areItemsTheSame(
                oldItem: CharacterAndLocationModel, newItem: CharacterAndLocationModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterAndLocationModel, newItem: CharacterAndLocationModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}