package com.ldaca.app.ready.data.domain

import com.ldaca.app.ready.data.server.Page

interface RemoteDataSource {
    suspend fun getPostsListFB(token: String, pageId: String): List<Post>
    suspend fun getPages(token: String): List<Page>
}