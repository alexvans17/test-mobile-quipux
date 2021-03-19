package com.quipux.persons.domain.interactor

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.RegisterPersonInteractor
import com.quipux.persons.domain.interfaces.repository.RegisterPersonRepository
import com.quipux.persons.ui.interfaces.presenter.RegisterPersonsPresenter
import com.quipux.persons.ui.presenter.RegisterPersonsPresenterImpl

class RegisterPersonInteractorImpl(private val registerPersonRepository: RegisterPersonRepository):
    RegisterPersonInteractor {

    init {
        this.registerPersonRepository.setInteractor(this)
    }

    private var registerPresenter: RegisterPersonsPresenter? = null

    override fun setPresenter(registerPersonsPresenter: RegisterPersonsPresenter) {
        this.registerPresenter = registerPersonsPresenter
    }

    override fun savePerson(context: Context, person: Person) {
        registerPersonRepository.savePerson(context, person)
    }

    override fun successSavePerson(message: String) {
        registerPresenter?.successSavePerson(message)
    }

    override fun failSavePerson(message: String) {
        registerPresenter?.failSavePerson(message)
    }
}