package com.example.lesson65.data.repositoryh

import android.util.Log
import com.example.lesson65.data.remote.RetrofitClient
import kotlinx.coroutines.flow.flow

class Repository {

    private val apiService = RetrofitClient.rickAndMortyApiService

    fun getCharacters() = flow {
        try {
            emit(apiService.getCharacters().results)
        } catch (e: Exception) {
            Log.e("character", e.message.toString())
        }
    }

    suspend fun getLocations() = flow {
        try {
            emit(apiService.getLocations().results)
        } catch (e: Exception) {
            Log.e("character", e.message.toString())
        }
    }
}