package com.quipux.persons.domain.interactor

import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.domain.interfaces.interactor.AuthInteractor
import com.quipux.persons.domain.interfaces.repository.AuthRepository
import com.quipux.persons.ui.interfaces.presenter.AuthPresenter

class AuthInteractorImpl(private val authRepository: AuthRepository):
    AuthInteractor {

    init {
        authRepository.setInteractor(this)
    }

    private var presenter : AuthPresenter? = null

    override fun setPresenter(presenter: AuthPresenter) {
        this.presenter = presenter
    }

    override fun login(username: String, password: String) {
        authRepository.login(username, password)
    }

    override fun successLogin(fakeUser: LoggedInUser) {
        presenter?.successLogin(fakeUser)
    }

    override fun failLogin(message: String) {
        presenter?.failLogin(message)
    }

    override fun logout() {
        authRepository.logout()
    }
}