package com.recipebook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recipebook.models.AccesResultModel
import com.recipebook.repositories.UserRegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class UserRegisterViewModel @Inject constructor(
    var userRegisterRepository: UserRegisterRepository): ViewModel() {

    //libera los recursos al usar programación reactiva
    private val compositeDisposable = CompositeDisposable()

    val userRegisterr:MutableLiveData<AccesResultModel> by lazy {
        MutableLiveData<AccesResultModel>()
        }

    fun userRegist(firstName:String,lastName:String,email:String,password:String,birthDay:String){
        compositeDisposable +=  userRegisterRepository.useRegister(
            firstName = firstName,lastName= lastName,email= email,password = password,birthDay = birthDay)
            .subscribeOn(Schedulers.io())
            .subscribe({accesResultmodel->
                    userRegisterr.postValue(accesResultmodel)
                },{
                    userRegisterr.postValue(AccesResultModel(
                        code = "-1",
                        message = "error!"
                    ))                        
                })
    }
        override fun onCleared()
        {
            compositeDisposable.clear()
            super.onCleared()
        }
}


