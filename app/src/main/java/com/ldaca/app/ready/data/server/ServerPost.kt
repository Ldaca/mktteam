package com.ldaca.app.ready.data.server

import com.google.gson.annotations.SerializedName

data class ServerPost (
    @SerializedName("id")
    val id: String = "",
    @SerializedName("message")
    val message: String = "",
    @SerializedName("picture")
    val imagePath: String = "",
    @SerializedName("created_time")
    val createAt: String = ""
)

data class ServerPostList(@SerializedName("data") val serverPostList: List<ServerPost>)