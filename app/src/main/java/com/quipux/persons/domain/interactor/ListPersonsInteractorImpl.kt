package com.quipux.persons.domain.interactor

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.ListPersonsInteractor
import com.quipux.persons.domain.interfaces.repository.ListPersonsRepository
import com.quipux.persons.ui.interfaces.presenter.ListPersonsPresenter
import com.quipux.persons.ui.interfaces.presenter.RegisterPersonsPresenter

class ListPersonsInteractorImpl(private val listPersonsRepository: ListPersonsRepository)
    :ListPersonsInteractor{

    init {
        this.listPersonsRepository.setInteractor(this)
    }

    private var presenter: ListPersonsPresenter? = null

    override fun setPresenter(listPersonsPresenter: ListPersonsPresenter) {
        this.presenter = listPersonsPresenter
    }

    override fun getAllPersons(context: Context) {
        listPersonsRepository.getAllPersons(context)
    }

    override fun successGetPersons(persons: MutableList<Person>?) {
        presenter?.successGetPersons(persons)
    }

    override fun emptyPersons() {
        presenter?.emptyPersons()
    }
}