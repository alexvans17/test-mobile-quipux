package com.quipux.persons.data.datasource.database

import android.content.Context
import android.util.Log
import com.quipux.persons.data.interfaces.ListPersonsDataBase
import com.quipux.persons.domain.interfaces.repository.ListPersonsRepository


class ListPersonsDataBaseImpl: ListPersonsDataBase {

    private lateinit var repository: ListPersonsRepository

    override fun setRepository(repository: ListPersonsRepository) {
        this.repository = repository
    }

    override fun getAllPersons(context: Context) {
        val dbHandler = PersonsDBOpenHelper(context, null)
        try {
            val persons = dbHandler.getAllPersons()

            if (persons!!.isEmpty()){
                repository.emptyPersons()
            }else
                repository.successGetPersons(persons)

        }catch (e: Exception){
            repository.emptyPersons()
            Log.d("Fail save", e.toString())
        }
    }
}