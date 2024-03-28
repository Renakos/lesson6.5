package com.example.lesson65.data.repositoryh

import com.example.lesson65.data.remote.RetrofitClient

class Repository {

    private val apiService = RetrofitClient.rickAndMortyApiService

    suspend fun getCharacter() = apiService.getCharacters()

    suspend fun getLocation() = apiService.getLocations()
}