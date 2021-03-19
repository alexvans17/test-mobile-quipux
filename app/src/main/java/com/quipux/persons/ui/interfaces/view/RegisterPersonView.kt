package com.quipux.persons.ui.interfaces.view

import android.content.Context
import com.quipux.persons.domain.entity.Person

interface RegisterPersonView {
    fun savePerson(context: Context, person: Person)
    fun successSave(message: String)
    fun showMessage(message: String)
    fun goToListPersonActivity()
    fun errorField(errorText: String, ed: String)
}