package com.ldaca.app.ready.data.domain

import com.ldaca.app.ready.data.server.Page

interface Repo {
    suspend fun getPostsList(token: String, provider: String, pageId: String): List<Post>
    suspend fun savePost(post: Post)
    suspend fun getPages(token: String): List<Page>
}