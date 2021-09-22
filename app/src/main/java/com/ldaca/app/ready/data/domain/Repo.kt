package com.ldaca.app.ready.data.domain

import com.ldaca.app.ready.data.server.Page

interface Repo {
    suspend fun getContacsList(): List<Contact>
    suspend fun saveContact(contact: Contact)
}