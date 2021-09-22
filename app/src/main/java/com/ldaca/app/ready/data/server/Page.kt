package com.ldaca.app.ready.data.server

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Page (
    @SerializedName("id")
    val idPage: String = "",
    @SerializedName("access_token")
    val pageToken: String = "",
    @SerializedName("name")
    val name: String = ""
)

data class ListPages(@SerializedName("data") val listPages: List<Page>): Serializable