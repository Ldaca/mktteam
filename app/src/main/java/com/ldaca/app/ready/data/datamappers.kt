package com.ldaca.app.ready.data


import com.ldaca.app.ready.data.domain.Post
import com.ldaca.app.ready.data.server.ServerPost
import com.ldaca.app.ready.utils.Providers
import com.ldaca.app.ready.data.db.Post as RoomPost

fun ServerPost.toDomainPost(): Post =
    Post(
        id,
        imagePath,
        message,
        createAt,
        Providers.FACEBOOK.toString()
    )

fun Post.toRoomPost(): RoomPost =
    RoomPost(
        id,
        imagePath,
        message,
        createAt,
        Providers.FACEBOOK.toString()
    )

fun RoomPost.toDomainPost(): Post =
    Post(
        id,
        imagePath,
        message,
        createAt,
        Providers.FACEBOOK.toString()
    )