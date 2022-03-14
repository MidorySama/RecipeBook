package com.recipebook.models

import com.google.gson.annotations.SerializedName

data class UserRequest (
    @SerializedName ("user_id") var idUser:String = "",
    @SerializedName ("email") var email: String = "",
    @SerializedName("password") var password: String = "" )