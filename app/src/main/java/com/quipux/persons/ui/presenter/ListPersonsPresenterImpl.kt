package com.quipux.persons.ui.presenter

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.ListPersonsInteractor
import com.quipux.persons.ui.interfaces.presenter.ListPersonsPresenter
import com.quipux.persons.ui.interfaces.view.ListPersonsView
import com.quipux.persons.ui.interfaces.view.RegisterPersonView

class ListPersonsPresenterImpl(private val listPersonsInteractor: ListPersonsInteractor)
    : ListPersonsPresenter{

    init {
        this.listPersonsInteractor.setPresenter(this)
    }

    private var listPersonView: ListPersonsView? = null

    override fun setView(listPersonsView: ListPersonsView): Boolean {
        this.listPersonView = listPersonsView
        return true
    }

    override fun getAllPersons(context: Context) {
        listPersonsInteractor.getAllPersons(context)
    }

    override fun successGetPersons(persons: MutableList<Person>?) {
        listPersonView?.setPersons(persons)
    }

    override fun emptyPersons() {
        listPersonView?.emptyPersons()
    }
}