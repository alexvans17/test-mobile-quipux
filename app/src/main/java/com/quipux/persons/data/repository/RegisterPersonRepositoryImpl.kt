package com.quipux.persons.data.repository

import android.content.Context
import com.quipux.persons.data.interfaces.DataBaseRegisterPerson
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.RegisterPersonInteractor
import com.quipux.persons.domain.interfaces.repository.RegisterPersonRepository

class RegisterPersonRepositoryImpl(private val dataBaseRegisterPerson: DataBaseRegisterPerson)
    : RegisterPersonRepository{

    init {
        this.dataBaseRegisterPerson.setRepository(this)
    }

    private lateinit var interactor: RegisterPersonInteractor

    override fun setInteractor(interactor: RegisterPersonInteractor) {
        this.interactor = interactor
    }

    override fun savePerson(context: Context, person: Person) {
        dataBaseRegisterPerson.savePerson(context, person)
    }

    override fun successSavePerson(message: String) {
        interactor.successSavePerson(message)
    }

    override fun failSavePerson(message: String) {
        interactor.failSavePerson(message)
    }
}