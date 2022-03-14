package com.recipebook.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.recipebook.databinding.ActivityUserRegisterBinding
import com.recipebook.models.AccesResultModel
import com.recipebook.platform.di.component.DatePickerFragment
import com.recipebook.viewmodel.UserRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistroUsuarioActivity : AppCompatActivity() {
    var binding: ActivityUserRegisterBinding? = null

    private val userRegisterVModel: UserRegisterViewModel by viewModels()
    var dateBirthService:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.Calendar?.setOnClickListener{
            val DateResult =
                DatePickerFragment { year, month, day -> dayResult(year, month, day) }
            DateResult.show(supportFragmentManager, "DateResult")
        }

        binding?.btnRegistro?.setOnClickListener{
            if (binding?.edPassword?.text.toString() == binding?.edRepeatPassword?.text.toString())
            {
                UserRegRequest(binding?.edName?.text.toString(),
                    binding?.edApellido?.text.toString(),
                    binding?.edEmail?.text.toString(),
                    binding?.edPassword?.text.toString(),
                    dateBirthService)
            }else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }

        binding?.tvBack?.setOnClickListener{
            startActivityLoggin()
        }
        initUserRegisterObserver()
    }

    // este es mi callback
    private val userRegisterResult = Observer<AccesResultModel> { accesResultModel ->
        if(accesResultModel.code == "0")
        {
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startActivityLoggin() {
        startActivity(Intent(this, LogginActivity::class.java))
        finish()
    }

    private fun initUserRegisterObserver(){
        userRegisterVModel.userRegisterr.observe(this, userRegisterResult)
    }

    private fun UserRegRequest(firstName: String,lastName:String,email:String,password:String,birthDay:String)
    {
        userRegisterVModel.userRegist(firstName,lastName,email,password,birthDay)
    }

    private fun dayResult(year:Int,month:Int,day:Int){
        val dat = ("0"+ month.toString()).takeLast(2)
        binding?.tvBirthDate?.text = "$day/$dat/$year"
        dateBirthService = "$year-$dat-$day"
    }

}
