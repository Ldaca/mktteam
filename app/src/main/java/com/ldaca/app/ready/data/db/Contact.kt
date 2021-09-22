package com.ldaca.app.ready.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey
    val id: String,
    val alias: String,
    val firstName: String,
    val lastName: String,
    val tel1: String,
    val tel2: String,
    val address1: String,
    val address2: String,
    val enterprise: String,
    val imagePath: String,
    val createAt: String
)