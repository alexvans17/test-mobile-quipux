package com.quipux.persons.ui.interfaces.view

import com.quipux.persons.data.model.LoggedInUser

interface AuthView {
    fun login(username : String, password: String )
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
}
