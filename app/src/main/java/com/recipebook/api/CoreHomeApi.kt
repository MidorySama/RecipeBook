package com.recipebook.api

import com.recipebook.models.ManyRecipeBookResponse
import com.recipebook.models.ManyUserAccessResponce
import com.recipebook.models.UserRegisterRequest
import com.recipebook.models.UserRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CoreHomeApi  {
    @GET("/recipe")
    @Headers("Content-Type: application/json ")
    fun getRecipeBook(): Single<ManyRecipeBookResponse>

    @POST("/access")
    @Headers("Content-Type: application/json ")
    fun userAccess(@Body userRequest: UserRequest): Single<ManyUserAccessResponce>

    @POST("/registerUser")
    @Headers("Content-Type: application/json ")
    fun usuRegister(@Body userRegister: UserRegisterRequest): Single<ManyUserAccessResponce>
}


