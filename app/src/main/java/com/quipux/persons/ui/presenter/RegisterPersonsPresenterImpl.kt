package com.quipux.persons.ui.presenter

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.interactor.RegisterPersonInteractor
import com.quipux.persons.ui.interfaces.presenter.RegisterPersonsPresenter
import com.quipux.persons.ui.interfaces.view.RegisterPersonView

class RegisterPersonsPresenterImpl(private val registerPersonInteractor: RegisterPersonInteractor):
    RegisterPersonsPresenter {

    init {
        this.registerPersonInteractor.setPresenter(this)
    }

    private var registerPersonView: RegisterPersonView? = null

    override fun setView(registerPersonView: RegisterPersonView): Boolean {
        this.registerPersonView = registerPersonView
        return true
    }

    override fun savePerson(context: Context, person: Person) {
        if (emptyText(person)) return
        if (!validateAge(person.age)) return
        registerPersonInteractor.savePerson(context, person)
    }

    override fun successSavePerson(message: String) {
        registerPersonView?.successSave(message)
    }

    override fun failSavePerson(message: String) {
        registerPersonView?.showMessage(message)
    }

    private fun emptyText(person: Person): Boolean {
        return if (
            person.documentNumber.trim().isEmpty() ||
            person.firstName.trim().isEmpty() ||
            person.lastName.trim().isEmpty()
        ) {
            registerPersonView?.showMessage("Complete todos los campos")
            true
        } else {
            false
        }
    }

    private fun validateAge(age: Int): Boolean {
        return if (age < 18) {
            registerPersonView?.errorField("La edad debe ser mayor de 18", "age")
            false
        } else {
            true
        }
    }
}