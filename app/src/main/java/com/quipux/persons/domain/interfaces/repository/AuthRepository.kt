package com.quipux.persons.domain.interfaces.repository

import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.domain.interfaces.interactor.AuthInteractor

interface AuthRepository {
    fun setInteractor(interactor: AuthInteractor)
    fun login(username: String, password: String)
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
    fun logout()
}