package com.recipebook.models

import com.google.gson.annotations.SerializedName

 data class ManyRecipeBookResponse (
    @SerializedName("recipes") val recipeBook: MutableList<RecipeBookResponse> = mutableListOf()
)