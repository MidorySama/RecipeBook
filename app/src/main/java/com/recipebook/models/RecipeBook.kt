package com.recipebook.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class RecipeBook(
    var idRecipeBook: String="",
    var name:String = "",
    var productPhoto: String = "",
    var authorB: String = "",
    var recipeBooks: String ="",
    var created_at: String=""
    ): Parcelable {}
