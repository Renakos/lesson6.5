package com.example.lesson65.data.remote.modellocation

import com.example.lesson65.data.remote.mainmodel.CharacterAndLocationModel
import com.google.gson.annotations.SerializedName

data class ResultItemLocation(
    @SerializedName("created")
    val created: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("residents")
    val residents: List<String>?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("url")
    val url: String? = null

)

fun ResultItemLocation.toCharacterLocation() = CharacterAndLocationModel(location = name)
