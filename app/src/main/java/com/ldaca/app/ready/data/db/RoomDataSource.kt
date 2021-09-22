package com.ldaca.app.ready.data.db

import com.ldaca.app.ready.data.domain.LocalDataSource
import com.ldaca.app.ready.data.domain.Contact
import com.ldaca.app.ready.data.toDomainContact
import com.ldaca.app.ready.data.toRoomContact
import javax.inject.Inject

class RoomDataSource @Inject constructor (private val contactDao: ContactDao): LocalDataSource {

    override suspend fun getContactssList(): List<Contact> =  contactDao.getAll().map { it.toDomainContact() }

    override suspend fun isEmpty(): Boolean = contactDao.contactCount() <= 0

    override suspend fun saveContacts(contacts: List<Contact>) {
        contactDao.insertContacts(contacts.map { it.toRoomContact() })
    }

    override suspend fun saveContact(contact: Contact) {
        contactDao.insertContact(contact.toRoomContact())
    }
}