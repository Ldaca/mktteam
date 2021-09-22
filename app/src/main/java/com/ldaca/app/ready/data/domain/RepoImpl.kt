package com.ldaca.app.ready.data.domain

import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repo {
    override suspend fun getContacsList(): List<Contact> {
        if (localDataSource.isEmpty()) {
            var contacts = emptyList<Contact>()
            contacts = remoteDataSource.getContactsList()

            localDataSource.saveContacts(contacts)
        }
        return localDataSource.getContactssList()
    }

    override suspend fun saveContact(contact: Contact) {
        localDataSource.saveContact(contact)
    }

}