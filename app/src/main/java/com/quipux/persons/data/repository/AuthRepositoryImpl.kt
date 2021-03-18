package com.quipux.persons.data.repository

import com.quipux.persons.data.interfaces.ApiAuth
import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.domain.interfaces.interactor.AuthInteractor
import com.quipux.persons.domain.interfaces.repository.AuthRepository


class AuthRepositoryImpl(private val apiAuth: ApiAuth):
    AuthRepository {

    init {
        apiAuth.setRepository(this)
    }

    private lateinit var interactor: AuthInteractor

    override fun setInteractor(interactor: AuthInteractor) {
        this.interactor = interactor
    }

    override fun login(username: String, password: String) {
        apiAuth.login(username, password)
    }

    override fun successLogin(fakeUser: LoggedInUser) {
        interactor.successLogin(fakeUser)
    }

    override fun failLogin(message: String) {
        interactor.failLogin(message)
    }

    override fun logout() {
        apiAuth.logout()
    }
}