package com.ldaca.app.ready.data.server

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{id_page}/feed?fields=picture,message,created_time")
    suspend fun getPosts(@Path("id_page") pageId: String, @Query(value = "access_token") token: String): ServerPostList

    @GET("me/accounts")
    suspend fun getPages(@Query(value = "access_token") token: String): ListPages
}