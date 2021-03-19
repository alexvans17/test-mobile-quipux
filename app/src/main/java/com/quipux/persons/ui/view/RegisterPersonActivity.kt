package com.quipux.persons.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.quipux.persons.R
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.ui.di.component.DaggerRegisterPersonComponent
import com.quipux.persons.ui.interfaces.view.RegisterPersonView
import com.quipux.persons.ui.presenter.RegisterPersonsPresenterImpl
import kotlinx.android.synthetic.main.activity_register_person.*
import javax.inject.Inject


class RegisterPersonActivity : AppCompatActivity(), RegisterPersonView {

    @Inject
    lateinit var presenter: RegisterPersonsPresenterImpl

    var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_person)

        DaggerRegisterPersonComponent.builder().build().inject(this)
        presenter.setView(this)

        button_cancel.setOnClickListener {

            AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Cancelar registro")
                .setMessage("¿Estás seguro(a) de finalizar el registro?")
                .setPositiveButton(
                    "Si"
                ) { _, _ ->
                    goToListPersonActivity()
                }
                .setNegativeButton(
                    "No"
                ) { dialogInterface, _ ->
                    dialogInterface.cancel()
                }
                .show()
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
                when (parentView?.getItemAtPosition(position) as String) {
                    "Cédula" -> {
                        input_identification?.inputType = InputType.TYPE_CLASS_NUMBER
                        input_identification?.setMaxLength(10)
                    }
                    "Tarjeta de identidad" -> {
                        input_identification?.inputType = InputType.TYPE_CLASS_NUMBER
                        input_identification?.setMaxLength(11)
                    }
                    else -> {
                        input_identification?.inputType = InputType.TYPE_CLASS_TEXT
                        input_identification?.setMaxLength(15)
                    }
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        button_register?.setOnClickListener {
            val ageValue = input_age.text.toString()
            if (ageValue.isNotEmpty()) {
                age = Integer.parseInt(ageValue)
            }

            if (age > 65) {
                AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Registro")
                    .setMessage("Vamos a ingresar una persona de la tercera edad, su edad es: $age")
                    .setPositiveButton(
                        "Si"
                    ) { _, _ ->
                        savePerson(
                            this,
                            Person(
                                spinner_identification_type?.selectedItem.toString(),
                                input_identification?.text.toString(),
                                input_first_name?.text.toString(),
                                input_last_name?.text.toString(),
                                spinner_gender?.selectedItem.toString(),
                                age
                            )
                        )
                    }
                    .setNegativeButton(
                        "No"
                    ) { dialogInterface, _ ->
                        dialogInterface.cancel()
                    }
                    .show()
            }
        }
    }

    private fun EditText.setMaxLength(maxLength: Int) {
        filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
    }

    override fun savePerson(context: Context, person: Person) {
        presenter.savePerson(context, person)
    }

    override fun successSave(message: String) {
        showMessage(message)
        goToListPersonActivity()
    }

    override fun showMessage(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun goToListPersonActivity() {
        val intent = Intent(this, ListPersonsActivity::class.java)
        startActivity(intent)
    }

    override fun errorField(errorText: String, ed: String) {
        when (ed) {
            "age" -> {
                input_age?.error = errorText
                input_age?.requestFocus()
            }
            "first_name" -> {
                input_first_name?.error = errorText
                input_first_name?.requestFocus()
            }
            "last_name" -> {
                input_last_name?.error = errorText
                input_last_name?.requestFocus()
            }
        }
    }
}