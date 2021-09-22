package com.ldaca.app.ready.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 2, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}