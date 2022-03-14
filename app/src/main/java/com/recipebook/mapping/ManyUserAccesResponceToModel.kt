package com.recipebook.mapping

import com.recipebook.models.AccesResultModel
import com.recipebook.models.ManyUserAccessResponce


internal fun ManyUserAccessResponce.toModel():AccesResultModel  =
     AccesResultModel(
         code = requestUserAccess.code,
         message = requestUserAccess.message,
     )



