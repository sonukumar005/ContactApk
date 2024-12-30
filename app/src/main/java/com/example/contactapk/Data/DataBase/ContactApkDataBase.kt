package com.example.contactapk.Data.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactapk.Data.table.Contact
import com.example.contactapk.Data.Dao.ContactApkDao

@Database(entities = [Contact::class], version = 1, exportSchema = false)
 abstract  class ContactApkDataBase: RoomDatabase() {
    abstract fun Contactdao(): ContactApkDao
}