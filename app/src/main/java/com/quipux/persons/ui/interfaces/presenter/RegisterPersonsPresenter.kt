package com.quipux.persons.ui.interfaces.presenter

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.ui.interfaces.view.RegisterPersonView

interface RegisterPersonsPresenter {
    fun setView(registerPersonView: RegisterPersonView): Boolean
    fun savePerson(context: Context, person: Person)
    fun successSavePerson(message: String)
    fun failSavePerson(message: String)
}