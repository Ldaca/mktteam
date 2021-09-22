package com.ldaca.app.ready.data.domain

interface RemoteDataSource {
    suspend fun getContactsList(): List<Contact>
}