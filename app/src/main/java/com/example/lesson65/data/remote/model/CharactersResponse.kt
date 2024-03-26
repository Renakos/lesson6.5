package com.example.lesson65.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("results")
    val results: List<ResultItemCharacter>?,
    @SerializedName("info")
    val info: Info
)