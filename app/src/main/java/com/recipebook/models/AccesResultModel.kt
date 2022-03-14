package com.recipebook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AccesResultModel(
    var code: String ="",
    var message: String="",
): Parcelable{}
