package com.ldaca.app.ready.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDao {

    @Query("SELECT * FROM Contact")
    suspend fun getAll(): List<Contact>

    @Query("SELECT COUNT(id) FROM Contact")
    suspend fun contactCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertContacts(contacts: List<Contact>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertContact(contact: Contact)
}