package com.ldaca.app.ready.data


import com.ldaca.app.ready.data.domain.Contact
import com.ldaca.app.ready.data.server.ServerContact
import com.ldaca.app.ready.data.db.Contact as RoomContact

fun ServerContact.toDomainContact(): Contact =
    Contact(
        id,
        alias,
        firstName,
        lastName,
        tel1,
        tel2,
        address1,
        address2,
        enterprise,
        imagePath,
        createAt
    )

fun Contact.toRoomContact(): RoomContact =
    RoomContact(
        id,
        alias,
        firstName,
        lastName,
        tel1,
        tel2,
        address1,
        address2,
        enterprise,
        imagePath,
        createAt
    )

fun RoomContact.toDomainContact(): Contact =
    Contact(
        id,
        alias,
        firstName,
        lastName,
        tel1,
        tel2,
        address1,
        address2,
        enterprise,
        imagePath,
        createAt
    )