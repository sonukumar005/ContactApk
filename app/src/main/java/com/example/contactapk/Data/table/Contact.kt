package com.example.contactapk.Data.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val dob: Long? = null,
    val imageUrl: ByteArray? = null


)