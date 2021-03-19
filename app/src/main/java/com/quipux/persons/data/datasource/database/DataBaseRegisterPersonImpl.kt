package com.quipux.persons.data.datasource.database

import android.content.Context
import android.util.Log
import com.quipux.persons.data.interfaces.DataBaseRegisterPerson
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.domain.interfaces.repository.RegisterPersonRepository
import java.lang.Exception

class DataBaseRegisterPersonImpl: DataBaseRegisterPerson {

    private lateinit var repository: RegisterPersonRepository

    override fun setRepository(repository: RegisterPersonRepository) {
        this.repository = repository
    }

    override fun savePerson(context: Context, person: Person) {
        val dbHandler = PersonsDBOpenHelper(context, null)
        try {
            dbHandler.addPerson(person)
            repository.successSavePerson("Registro exitoso")
        }catch (e: Exception){
            repository.failSavePerson("No se pudo registrar")
            Log.d("Fail save", e.toString())
        }
    }
}