package com.quipux.persons.domain.interfaces.interactor

import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.ui.interfaces.presenter.AuthPresenter

interface AuthInteractor {
    fun setPresenter(presenter: AuthPresenter)
    fun login(username: String, password: String)
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
    fun logout()
}
