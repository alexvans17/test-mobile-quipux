package com.quipux.persons.ui.interfaces.presenter

import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.ui.interfaces.view.AuthView

interface AuthPresenter {
    fun setView(view: AuthView): Boolean
    fun login(username: String, password: String)
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
    fun logout()
}
