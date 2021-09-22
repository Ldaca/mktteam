package com.ldaca.app.ready.data.server

import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getContacts(): ServerContactList
}