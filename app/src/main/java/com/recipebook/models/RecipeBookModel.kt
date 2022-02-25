package com.recipebook.models

import android.os.Parcelable
@kotlinx.android.parcel.Parcelize

class RecipeBookModel(
    var idRecipeBook: String="",
    var name:String = "",
    var productPhoto: String = "",
    var authorB: String = "",
    var recipeBooks: String ="",
    var created_at: String=""

) : Parcelable {}