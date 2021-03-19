package com.quipux.persons.domain.interfaces.repository

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.ListPersonsInteractor

interface ListPersonsRepository {
    fun setInteractor(listPersonsInteractor: ListPersonsInteractor)
    fun getAllPersons(context: Context)
    fun successGetPersons(persons: MutableList<Person>?)
    fun emptyPersons()
}