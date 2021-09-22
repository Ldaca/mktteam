package com.ldaca.app.ready.data.server

import com.ldaca.app.ready.data.domain.Post
import com.ldaca.app.ready.data.domain.RemoteDataSource
import com.ldaca.app.ready.data.toDomainPost
import javax.inject.Inject

class ServerDataSource @Inject constructor (private val apiService: ApiService): RemoteDataSource {

    override suspend fun getPostsListFB(token: String, pageId: String): List<Post> = apiService.getPosts(pageId, token).serverPostList
        .map { it.toDomainPost() }

    override suspend fun getPages(token: String): List<Page> = apiService.getPages(token).listPages
}