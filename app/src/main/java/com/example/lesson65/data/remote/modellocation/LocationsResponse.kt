package com.example.lesson65.data.remote.modellocation

import com.google.gson.annotations.SerializedName

data class LocationsResponse(
    @SerializedName("results")
    val results: List<ResultItemLocation>?,
    @SerializedName("info")
    val info: Info
)