package com.recipebook.models

import com.google.gson.annotations.SerializedName

data class RecipeBookResponse(
    @SerializedName("recipe_id") val idRecipeBook: String="",
    @SerializedName("title") val name: String = "",
    @SerializedName("image_url") val productPhoto: String = "",
    @SerializedName("detail") val recipeBooks: String = "",
    @SerializedName("author") val author: String = "",
    @SerializedName("created_at") val created_at: String = ""
)