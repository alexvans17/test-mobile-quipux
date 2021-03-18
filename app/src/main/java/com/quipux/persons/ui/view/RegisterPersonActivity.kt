package com.quipux.persons.ui.view

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.quipux.persons.R
import kotlinx.android.synthetic.main.activity_register_person.*


class RegisterPersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_person)

        button_cancel.setOnClickListener {
            onBackPressed()
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.identification_type,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_identification_type?.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.gender,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_gender?.adapter = adapter
        }

        spinner_identification_type.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                input_identification?.text = null
                when(parentView?.getItemAtPosition(position) as String){
                    "Cédula", "Tarjeta de identidad" -> input_identification?.inputType = InputType.TYPE_CLASS_NUMBER
                    else -> input_identification?.inputType = InputType.TYPE_CLASS_TEXT
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }
    }
}