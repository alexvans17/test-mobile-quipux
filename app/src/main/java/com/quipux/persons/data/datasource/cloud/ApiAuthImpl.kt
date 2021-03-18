package com.quipux.persons.data.datasource.cloud

import com.quipux.persons.data.interfaces.ApiAuth
import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.domain.interfaces.repository.AuthRepository

class ApiAuthImpl: ApiAuth {

    private lateinit var repository: AuthRepository

    override fun setRepository(repository: AuthRepository) {
        this.repository = repository
    }

    override fun login(username: String, password: String) {
        try {
            if (username=="admin" && password=="12345"){
                val fakeUser = LoggedInUser(
                    java.util.UUID.randomUUID().toString(),
                    "Jane Doe", "+9999999", "janedoe@admin.com")
                repository.successLogin(fakeUser)
            }else
                repository.failLogin("Usuario no válido")

        } catch (e: Throwable) {
            repository.failLogin(e.toString())
        }
    }

    override fun logout() {
        // TODO: revoke authentication
    }
}