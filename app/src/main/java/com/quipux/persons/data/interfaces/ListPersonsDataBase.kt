package com.quipux.persons.data.interfaces

import android.content.Context
import com.quipux.persons.domain.interfaces.repository.ListPersonsRepository

interface ListPersonsDataBase {
    fun setRepository(repository: ListPersonsRepository)
    fun getAllPersons(context: Context)
}