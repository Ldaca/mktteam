package com.ldaca.app.ready.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey
    val id: String,
    val imagePath: String,
    val message: String,
    val createAt: String,
    val provider: String
)