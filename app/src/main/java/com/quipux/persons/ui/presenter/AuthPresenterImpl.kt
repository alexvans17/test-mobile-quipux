package com.quipux.persons.ui.presenter

import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.domain.interfaces.interactor.AuthInteractor
import com.quipux.persons.ui.interfaces.presenter.AuthPresenter
import com.quipux.persons.ui.interfaces.view.AuthView

class AuthPresenterImpl(private val authInteractor: AuthInteractor):
    AuthPresenter {

    init {
        authInteractor.setPresenter(this)
    }

    private var authView: AuthView? = null

    override fun setView(view: AuthView): Boolean {
        this.authView = view
        return true
    }

    override fun login(username: String, password: String) {
        authInteractor.login(username, password)
    }

    override fun successLogin(fakeUser: LoggedInUser) {
        authView?.successLogin(fakeUser)
    }

    override fun failLogin(message: String) {
        authView?.failLogin(message)
    }

    override fun logout() {
        authInteractor.logout()
    }
}