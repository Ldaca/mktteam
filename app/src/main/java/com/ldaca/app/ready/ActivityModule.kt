package com.ldaca.app.ready

import com.ldaca.app.ready.data.db.RoomDataSource
import com.ldaca.app.ready.data.domain.LocalDataSource
import com.ldaca.app.ready.data.domain.RemoteDataSource
import com.ldaca.app.ready.data.domain.Repo
import com.ldaca.app.ready.data.domain.RepoImpl
import com.ldaca.app.ready.data.server.ServerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindRepoImpl(repoImpl: RepoImpl): Repo

    @Binds
    abstract fun bindRoomDatasource(roomDataSource: RoomDataSource): LocalDataSource

    @Binds
    abstract fun bindServerDatasource(serverDataSource: ServerDataSource): RemoteDataSource
}