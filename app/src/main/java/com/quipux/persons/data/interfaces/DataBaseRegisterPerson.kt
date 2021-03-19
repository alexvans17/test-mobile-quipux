package com.quipux.persons.data.interfaces

import android.content.Context
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.repository.RegisterPersonRepository

interface DataBaseRegisterPerson {
    fun setRepository(repository: RegisterPersonRepository)
    fun savePerson(context: Context, person: Person)
}