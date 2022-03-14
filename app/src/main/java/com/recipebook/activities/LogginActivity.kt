package com.recipebook.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.recipebook.databinding.ActivityLogginBinding
import com.recipebook.models.AccesResultModel
import com.recipebook.viewmodel.RecipeBookViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LogginActivity: AppCompatActivity() {

    var binding:ActivityLogginBinding? = null
    private val modelUserAcces:RecipeBookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogginBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        binding?.tvRegistro?.setOnClickListener{
            starActivityRegistroUsu()
        }

        binding?.btnEnter?.setOnClickListener{

            userAcces(binding?.eteMail?.text.toString(),"3fa85f64-5717-4562-b3fc-2c963f66afa6", binding?.edPassword?.text.toString())
        }
        binding?.tvSalir?.setOnClickListener{
            finish()
        }

        initLoginObserver()

    }

// este es mi callback
    private val userAcces = Observer<AccesResultModel> { accesResultModel ->
         if (accesResultModel.code == "0") {
             startActivityItemRecipeBook()
         } else {
            Toast.makeText(this, "Incorrect user or password", Toast.LENGTH_SHORT).show()
         }
    }

    private fun initLoginObserver(){
        modelUserAcces.userAcces.observe(this,userAcces)
    }

    fun userAcces(email:String,idUser:String,pasword:String)
    {
        modelUserAcces.userAcces(email,idUser,pasword)
    }

    fun starActivityRegistroUsu(){
        startActivity(Intent(this, RegistroUsuarioActivity::class.java))
        finish()
    }

    fun startActivityItemRecipeBook(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


}