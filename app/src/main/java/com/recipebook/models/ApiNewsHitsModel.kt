package com.recipebook.models

import com.google.gson.annotations.SerializedName

data class ApiNewsHitsModel(
    @SerializedName("hits") val hits: MutableList<ApiHitModel> = mutableListOf(),
    @SerializedName("page") val page: Int = 0,
    @SerializedName("nbPage") val totalPage: Int =0,
    @SerializedName("hitsPerpage") val hitsPerpage: Int = 0
)