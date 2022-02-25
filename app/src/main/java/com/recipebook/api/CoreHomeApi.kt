package com.recipebook.api

import com.recipebook.models.ApiNewsHitsModel
import com.recipebook.models.Constant.Companion.QUERY_HITS
import com.recipebook.models.ManyRecipeBookResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CoreHomeApi  {
    @GET("/api/v1/search_by_date")
    @Headers("Content-Type: application/json")

    fun getHits(
        @Query("query") query: String = QUERY_HITS,
        @Query("page") page :Int = 0
    ): Observable<ApiNewsHitsModel>

    @GET("/recipe")
    @Headers("Content-Type: application/json ")
    fun getRecipeBook( ): Single<ManyRecipeBookResponse>
}


