package com.quipux.persons.domain.interfaces.interactor

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.ui.interfaces.presenter.RegisterPersonsPresenter

interface RegisterPersonInteractor {
    fun setPresenter(registerPersonsPresenter: RegisterPersonsPresenter)
    fun savePerson(context: Context, person: Person)
    fun successSavePerson(message: String)
    fun failSavePerson(message: String)
}