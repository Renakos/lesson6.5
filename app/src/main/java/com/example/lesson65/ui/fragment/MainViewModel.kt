package com.example.lesson65.ui.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson65.data.remote.mainmodel.CharacterAndLocationModel
import com.example.lesson65.data.remote.model.ResultItemCharacter
import com.example.lesson65.data.remote.modellocation.ResultItemLocation
import com.example.lesson65.data.repositoryh.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = Repository()
    private var _locationCharacterState = MutableLiveData<List<CharacterAndLocationModel>>()
    val locationCharacterState: LiveData<List<CharacterAndLocationModel>> = _locationCharacterState

    init {
        loadDataCharacters()
    }

    private fun loadDataCharacters() {
        viewModelScope.launch {
            val characters = async {
                repository.getCharacter()
            }
            val location = async {
                repository.getLocation()
            }
            characters.await().results?.let { characters ->
                location.await().results?.let { locations ->
                    connectList(characters,locations)
                }
            }
        }
    }

    private fun connectList(
        characterList: List<ResultItemCharacter>, locationList: List<ResultItemLocation>
    ) {
        val combinedList = characterList.zip(locationList).map { (character) ->
            CharacterAndLocationModel(character.species, character.name, character.location.name)
        }
        _locationCharacterState.value = combinedList
        Log.e("tag", _locationCharacterState.value.toString())
        Log.e("tag", combinedList.toString())
    }
}