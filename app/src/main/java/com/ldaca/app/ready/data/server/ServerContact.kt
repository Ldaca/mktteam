package com.ldaca.app.ready.data.server

import com.google.gson.annotations.SerializedName

data class ServerContact (
    @SerializedName("id")
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

data class ServerContactList(@SerializedName("data") val serverContactList: List<ServerContact>)