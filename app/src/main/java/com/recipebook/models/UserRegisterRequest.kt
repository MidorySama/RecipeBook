package com.recipebook.models

import com.google.gson.annotations.SerializedName

data class UserRegisterRequest (
     @SerializedName("first_name") var firstName:String = "",
     @SerializedName("last_name") var lastName:String = "",
     @SerializedName("email") var email:String = "",
     @SerializedName("password") var password:String = "",
     @SerializedName("birth_date") var birthDay:String = "",


         )