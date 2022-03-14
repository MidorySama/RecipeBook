package com.recipebook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserAcces ( var email: String = "",
    var idUser: String= "",
    var password: String ="",


):Parcelable