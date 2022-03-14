package com.recipebook.models

import com.google.gson.annotations.SerializedName

data class ManyUserAccessResponce (
    @SerializedName("result") val requestUserAccess: UserAccessResult = UserAccessResult())
