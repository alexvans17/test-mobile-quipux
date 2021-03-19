package com.quipux.persons.domain.interfaces.repository

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.RegisterPersonInteractor

interface RegisterPersonRepository {
    fun setInteractor(interactor: RegisterPersonInteractor)
    fun savePerson(context: Context, person: Person)
    fun successSavePerson(message: String)
    fun failSavePerson(message: String)
}