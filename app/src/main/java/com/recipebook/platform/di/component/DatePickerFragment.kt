package com.recipebook.platform.di.component

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

//aquí se configura el datepicker fragment
class DatePickerFragment ( val listener:(year:Int, month:Int,day:Int)->Unit):
      DialogFragment(), DatePickerDialog.OnDateSetListener{

        override fun onCreateDialog(savedInstanceState:Bundle?):Dialog
        {
            val cale = Calendar.getInstance()
            val year = cale.get(Calendar.YEAR)-18
            val month = cale.get(Calendar.MONTH)
            val day = cale.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(requireActivity(),this, year, month, day)
        }

     override fun onDateSet(p0:android.widget.DatePicker?,year: Int,month: Int,day: Int){
          listener(year,month+1,day)
    }

}