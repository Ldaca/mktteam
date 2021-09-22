package com.ldaca.app.ready.data.domain

interface LocalDataSource {
    suspend fun getPostsListByProvider(provider: String): List<Post>
    suspend fun isEmpty(): Boolean
    suspend fun savePosts(posts: List<Post>)
    suspend fun savePost(post: Post)
}