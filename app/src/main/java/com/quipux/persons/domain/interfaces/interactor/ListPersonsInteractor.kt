package com.quipux.persons.domain.interfaces.interactor

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.ui.interfaces.presenter.ListPersonsPresenter

interface ListPersonsInteractor {
    fun setPresenter(listPersonsPresenter: ListPersonsPresenter)
    fun getAllPersons(context: Context)
    fun successGetPersons(persons: MutableList<Person>?)
    fun emptyPersons()
}