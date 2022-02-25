package com.recipebook.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.recipebook.databinding.ActivityLogginBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LogginActivity: AppCompatActivity() {

    var binding:ActivityLogginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogginBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_login)
        setContentView(binding?.root)

        val tv_registro = binding?.tvRegistro as TextView
        val btn_enter = binding?.btnEnter as TextView


        tv_registro.setOnClickListener{
            starActivityRegistroUsu()
        }

        btn_enter.setOnClickListener{
            startActivityItemRecipeBook()
        }

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