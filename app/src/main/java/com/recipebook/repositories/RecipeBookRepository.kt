package com.recipebook.repositories

import com.recipebook.api.CoreHomeApi
import com.recipebook.mapping.toModel
import com.recipebook.models.RecipeBook
import io.reactivex.Single
import javax.inject.Inject

class RecipeBookRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

   /* fun getRecipebook(): Single<ArrayList<RecipeBook>>
    {
        var listRecipebook: ArrayList<RecipeBook> = arrayListOf()
        listRecipebook.add(RecipeBook(
            idRecipeBook = 0,
            name = "Agua de Fresa", productPhoto = R.drawable.aguafresa, authorB = "Ana Pimentel", recipeBook = "20 fresas, lavadas y desinfectada 5 tazas de agua endulzantes sin calorías, al gusto hielos 10 hojas de menta azúcar, al gusto." +
                    " Preparación  Partir el resto de las fresas por la mitad  Agregar la mezcla de fresas con agua, el resto del agua, los hielos, el endulzante, las fresas partidas y la menta. Servir." ))

        listRecipebook.add(RecipeBook(
            idRecipeBook = 1,
            name = "Pozole rojo", productPhoto = R.drawable.pozolerojo, authorB = "Rosa Jimenez", recipeBook = "",
           ))

        listRecipebook.add(RecipeBook(
            idRecipeBook = 2,
            name = "Flautas de Pollo",
            productPhoto = R.drawable.flautaspollo, authorB = "Jannete Cermeño", recipeBook = "",))

        listRecipebook.add(RecipeBook(
            idRecipeBook = 3,
            name = "Pezcado Frito", productPhoto = R.drawable.pezcadofrito, authorB = "Neri Mercado",recipeBook = "", ))

        listRecipebook.add(RecipeBook(
            idRecipeBook = 3,
            name = "Rollo de Carne", productPhoto = R.drawable.rollocarne, authorB = "Ericka Alcaraz",recipeBook = "", ))

        return Single.just(listRecipebook)
    }*/

    fun getRecipebook(): Single<MutableList<RecipeBook>>
    {
        return apiService.getRecipeBook()
            .map { recipeBook ->
                recipeBook.toModel()
            }
    }

}

