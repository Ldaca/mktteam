package com.ldaca.app.ready.data.server

import com.ldaca.app.ready.data.domain.Contact
import com.ldaca.app.ready.data.domain.RemoteDataSource
import com.ldaca.app.ready.data.toDomainContact
import javax.inject.Inject

class ServerDataSource @Inject constructor (private val apiService: ApiService): RemoteDataSource {

    override suspend fun getContactsList(): List<Contact> = apiService.getContacts().serverContactList
        .map { it.toDomainContact() }

}