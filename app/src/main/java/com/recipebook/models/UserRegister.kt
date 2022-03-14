package com.recipebook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class UserRegister (
    var firstName: String = "",
    var lastName:String ="",
    var email:String = "",
    var password:String="",
    var repeatPassword:String = "",
    var birthDay:String = ""
) : Parcelable{}