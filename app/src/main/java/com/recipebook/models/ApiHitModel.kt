package com.recipebook.models

import com.google.gson.annotations.SerializedName

class ApiHitModel (
    @SerializedName("recipe_id") val recipe_id: String= "",
    @SerializedName("title") val title: String = "",
    @SerializedName("author") val author: String = "",
    @SerializedName("detail") val recipeBooks: String = "",
    @SerializedName("image_url") val image_url: String = "",
    @SerializedName("created_at") val created_at: String = ""
)