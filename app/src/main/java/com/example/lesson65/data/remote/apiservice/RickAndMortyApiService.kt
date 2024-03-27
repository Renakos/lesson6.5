package com.example.lesson65.data.remote.apiservice

import com.example.lesson65.data.remote.model.CharactersResponse
import com.example.lesson65.data.remote.modellocation.LocationsResponse
import retrofit2.http.GET

private const val CHARACTERS_END_POINT = "character"
private const val LOCATIONS_END_POINT = "location"

interface RickAndMortyApiService {

    @GET(CHARACTERS_END_POINT)
    suspend fun getCharacters(): CharactersResponse

    @GET(LOCATIONS_END_POINT)
    suspend fun getLocations(): LocationsResponse

}