package com.ldaca.app.ready.data.domain

interface LocalDataSource {
    suspend fun getContactssList(): List<Contact>
    suspend fun isEmpty(): Boolean
    suspend fun saveContacts(contacts: List<Contact>)
    suspend fun saveContact(contact: Contact)
}