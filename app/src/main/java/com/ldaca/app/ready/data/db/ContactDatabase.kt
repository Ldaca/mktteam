package com.ldaca.app.ready.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 2, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}