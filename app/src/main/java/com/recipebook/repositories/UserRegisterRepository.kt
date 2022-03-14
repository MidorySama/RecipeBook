package com.recipebook.repositories

import com.recipebook.api.CoreHomeApi
import com.recipebook.mapping.toModel
import com.recipebook.models.AccesResultModel
import com.recipebook.models.UserRegisterRequest
import io.reactivex.Single
import javax.inject.Inject

class UserRegisterRepository @Inject constructor(
    private val apiService : CoreHomeApi){

    fun useRegister (firstName:String,lastName:String,email:String,password:String,
                     birthDay:String): Single<AccesResultModel> {
        return apiService.usuRegister(
            userRegister = UserRegisterRequest(
             firstName= firstName,
                lastName = lastName,
                email= email,
                password = password,
                birthDay = birthDay
            )
        )
            .map { useRegister->
                useRegister.toModel()
            }
    }
}