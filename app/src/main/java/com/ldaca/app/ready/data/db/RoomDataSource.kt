package com.ldaca.app.ready.data.db

import com.ldaca.app.ready.data.domain.LocalDataSource
import com.ldaca.app.ready.data.domain.Post
import com.ldaca.app.ready.data.toDomainPost
import com.ldaca.app.ready.data.toRoomPost
import javax.inject.Inject

class RoomDataSource @Inject constructor (private val postDao: PostDao): LocalDataSource {

    override suspend fun getPostsListByProvider(provider: String): List<Post> =  postDao.getAllByProvider(provider).map { it.toDomainPost() }

    override suspend fun isEmpty(): Boolean = postDao.postCount() <= 0

    override suspend fun savePosts(posts: List<Post>) {
        postDao.insertPosts(posts.map { it.toRoomPost() })
    }

    override suspend fun savePost(post: Post) {
        postDao.insertPost(post.toRoomPost())
    }
}