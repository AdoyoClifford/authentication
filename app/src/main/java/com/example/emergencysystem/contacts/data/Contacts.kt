package com.example.emergencysystem.contacts.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contacts(
    val title: String,
    val description: String?,
    val isDone: Boolean,
    @PrimaryKey val id: Int? = null
)
