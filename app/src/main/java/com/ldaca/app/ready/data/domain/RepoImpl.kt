package com.ldaca.app.ready.data.domain

import com.ldaca.app.ready.data.server.Page
import com.ldaca.app.ready.utils.Providers
import javax.inject.Inject

class RepoImpl @Inject constructor (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource) : Repo {
    override suspend fun getPostsList(token: String, provider: String, pageId: String): List<Post> {
        if (localDataSource.isEmpty()) {
            var posts = emptyList<Post>()
            when (provider) {
                Providers.FACEBOOK.toString() -> {
                    posts = remoteDataSource.getPostsListFB(token, pageId)
                }
                Providers.TWITTER.toString() -> {}
                Providers.INSTAGRAM.toString() -> {}
            }

            localDataSource.savePosts(posts)
        }
        return localDataSource.getPostsListByProvider(provider)
    }

    override suspend fun savePost(post: Post) {
        localDataSource.savePost(post)
    }

    override suspend fun getPages(token: String): List<Page> = remoteDataSource.getPages(token)
}