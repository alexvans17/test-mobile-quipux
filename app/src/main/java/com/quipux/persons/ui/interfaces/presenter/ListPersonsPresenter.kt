package com.quipux.persons.ui.interfaces.presenter

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.ui.interfaces.view.ListPersonsView

interface ListPersonsPresenter {
    fun setView(listPersonsView: ListPersonsView): Boolean
    fun getAllPersons(context: Context)
    fun successGetPersons(persons: MutableList<Person>?)
    fun emptyPersons()
}