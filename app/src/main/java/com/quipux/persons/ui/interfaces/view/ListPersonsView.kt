package com.quipux.persons.ui.interfaces.view


import android.content.Context
import com.quipux.persons.domain.entity.Person

interface ListPersonsView {
    fun getAllPersons(context: Context)
    fun setPersons(persons: MutableList<Person>?)
    fun emptyPersons()
}