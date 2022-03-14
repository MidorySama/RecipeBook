package com.recipebook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recipebook.models.AccesResultModel
import com.recipebook.models.RecipeBookResult
import com.recipebook.repositories.RecipeBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class RecipeBookViewModel @Inject constructor(
    var recipeBookRepository: RecipeBookRepository) : ViewModel()
{

    // Ayuda a liberar los recursos cuando usamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()


    val listRecipeBook: MutableLiveData<RecipeBookResult> by lazy {
        MutableLiveData<RecipeBookResult>()
    }

    val  userAcces:MutableLiveData<AccesResultModel> by lazy {
        MutableLiveData<AccesResultModel>()
    }

    fun getRecipeBook() {
        compositeDisposable += recipeBookRepository.getRecipebook()
            .subscribeOn(Schedulers.io())
            .subscribe({ listProds ->
                listRecipeBook.postValue(
                    RecipeBookResult(
                        susses = true,
                        list = listProds
                    )
                )
            },{
                listRecipeBook.postValue(
                    RecipeBookResult(
                        susses = false
                    )
                )
            })
    }

    fun userAcces(email:String,idUser:String,password:String)
    {
        compositeDisposable += recipeBookRepository.userAccess(
        email = email,idUser=idUser,password = password)
            .subscribeOn(Schedulers.io())
            .subscribe(
            {accesResultModel->
                userAcces.postValue(accesResultModel)
            },
            { error->
                userAcces.postValue(AccesResultModel(
                    code ="1",
                    message = "error!",
                ))
            })
    }


    override fun onCleared()
    {
        compositeDisposable.clear()
        super.onCleared()
    }
}





