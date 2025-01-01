package com.example.contactapk.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.contactapk.Data.table.Contact
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactApkDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)


    @Delete
    suspend fun DeleteContact(contact: Contact)

    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun getAllContacts(): Flow<List<Contact>>
}