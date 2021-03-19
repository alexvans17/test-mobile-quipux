package com.quipux.persons.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    val documentType: String,
    @PrimaryKey val documentNumber: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val age: Int
)