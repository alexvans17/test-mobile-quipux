package com.quipux.persons.data.datasource.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.quipux.persons.domain.entity.Person

class PersonsDBOpenHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME,
        factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PERSONS_TABLE = ("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_DOCUMENT_TYPE + " TEXT,"
                + COLUMN_DOCUMENT_NUMBER + " TEXT PRIMARY KEY,"
                + COLUMN_FIRST_NAME + " TEXT,"
                + COLUMN_LAST_NAME + " TEXT,"
                + COLUMN_GENDER + " TEXT,"
                + COLUMN_AGE + " INTEGER" +
                ");"
                )
        db.execSQL(CREATE_PERSONS_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addPerson(person: Person) {
        val values = ContentValues()
        values.put(COLUMN_DOCUMENT_TYPE, person.documentType)
        values.put(COLUMN_DOCUMENT_NUMBER, person.documentNumber)
        values.put(COLUMN_FIRST_NAME, person.firstName)
        values.put(COLUMN_LAST_NAME, person.lastName)
        values.put(COLUMN_GENDER, person.gender)
        values.put(COLUMN_AGE, person.age)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllPersons(): MutableList<Person>? {
        val db = this.readableDatabase
        val personList: MutableList<Person> = mutableListOf()
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        while (cursor.moveToNext()) {

            val documentType = cursor.getString(cursor.getColumnIndex(COLUMN_DOCUMENT_TYPE))
            val documentNumber = cursor.getString(cursor.getColumnIndex(COLUMN_DOCUMENT_NUMBER))
            val firstName = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME))
            val gender = cursor.getString(cursor.getColumnIndex(COLUMN_GENDER))
            val age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE))

            val person = Person(
                documentType,
                documentNumber,
                firstName,
                lastName,
                gender,
                age
            )
            personList.add(person)
        }
        cursor.close()
        return personList
    }

    companion object {
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "quipux_persons.db"
        const val TABLE_NAME = "persons"
        const val COLUMN_DOCUMENT_TYPE = "document_type"
        const val COLUMN_DOCUMENT_NUMBER = "document_number"
        const val COLUMN_FIRST_NAME = "first_name"
        const val COLUMN_LAST_NAME = "last_name"
        const val COLUMN_AGE = "age"
        const val COLUMN_GENDER = "gender"
    }
}