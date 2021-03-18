package com.quipux.persons.data.interfaces

import com.quipux.persons.domain.interfaces.repository.AuthRepository

interface ApiAuth {
    fun setRepository(repository: AuthRepository)
    fun login(username: String, password: String)
    fun logout()
}