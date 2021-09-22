package com.ldaca.app.ready

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.ldaca.app.ready.data.db.ContactDatabase
import com.ldaca.app.ready.data.server.ApiService
import com.ldaca.app.ready.data.server.RetrofitBuilder.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ContactDatabase::class.java, "post-db").build()

    @Singleton
    @Provides
    fun provideContactDao(db: ContactDatabase) = db.contactDao()

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}