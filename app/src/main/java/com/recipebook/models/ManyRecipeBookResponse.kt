package com.recipebook.models

import com.google.gson.annotations.SerializedName

class ManyRecipeBookResponse (
    @SerializedName("recipes") val recipeBook: MutableList<RecipeBookResponse> = mutableListOf()
)