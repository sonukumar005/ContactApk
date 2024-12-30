package com.example.contactapk.repo

import com.example.contactapk.Data.DataBase.ContactApkDataBase
import com.example.contactapk.Data.table.Contact
import kotlinx.coroutines.flow.Flow

class Repo (val database: ContactApkDataBase){
    suspend fun upsertContact(contact: Contact) {
        database.Contactdao().upsertContact(contact)
    }
    suspend fun deleteContact(contact: List<Contact>) {
        database.Contactdao().DeleteContact(contact)

    }
    fun getAllContacts(): Flow<List<Contact>> {
        return database.Contactdao().getAllContacts()
    }

}