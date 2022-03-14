package com.recipebook.repositories

import com.recipebook.api.CoreHomeApi
import com.recipebook.mapping.toModel
import com.recipebook.models.AccesResultModel
import com.recipebook.models.RecipeBook
import com.recipebook.models.UserRequest
import io.reactivex.Single
import javax.inject.Inject

class RecipeBookRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun getRecipebook(): Single<MutableList<RecipeBook>>
    {
        return apiService.getRecipeBook()
            .map { recipeBook ->
                recipeBook.toModel()
            }
    }

    fun userAccess(email:String,idUser:String,password:String): Single<AccesResultModel>
    {
        return apiService.userAccess(UserRequest(
            email= email,
            idUser = idUser,
            password = password))

            .map { userAccessResponce->
                userAccessResponce.toModel()}
    }



}

