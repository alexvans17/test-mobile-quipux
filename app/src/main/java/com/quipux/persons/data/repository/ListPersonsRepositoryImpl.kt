package com.quipux.persons.data.repository

import android.content.Context
import com.quipux.persons.data.interfaces.ListPersonsDataBase
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.ListPersonsInteractor
import com.quipux.persons.domain.interfaces.repository.ListPersonsRepository

class ListPersonsRepositoryImpl(private val listPersonsDataBase: ListPersonsDataBase)
    :ListPersonsRepository{

    init {
        this.listPersonsDataBase.setRepository(this)
    }

    private lateinit var interactor: ListPersonsInteractor

    override fun setInteractor(listPersonsInteractor: ListPersonsInteractor) {
        this.interactor = listPersonsInteractor
    }

    override fun getAllPersons(context: Context) {
        listPersonsDataBase.getAllPersons(context)
    }

    override fun successGetPersons(persons: MutableList<Person>?) {
        interactor.successGetPersons(persons)
    }

    override fun emptyPersons() {
        interactor.emptyPersons()
    }
}