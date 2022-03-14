package com.recipebook.mapping

import com.recipebook.models.ManyRecipeBookResponse
import com.recipebook.models.RecipeBook

internal fun ManyRecipeBookResponse.toModel(): MutableList<RecipeBook> {
    val productList: MutableList<RecipeBook> = mutableListOf()


    recipeBook.map { prod ->
        productList.add(
            RecipeBook(
                idRecipeBook = prod.idRecipeBook,
                name = prod.name,
                productPhoto = prod.productPhoto,
                authorB = prod.author,
                recipeBooks= prod.recipeBooks,
                created_at = prod.created_at,


            )
        )
    }

    return productList



}