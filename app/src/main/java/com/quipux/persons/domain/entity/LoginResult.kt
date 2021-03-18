package com.quipux.persons.domain.entity

data class LoginResult(
        val success: LoggedInUserView? = null,
        val error: Int? = null
)