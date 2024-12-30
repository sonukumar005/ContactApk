package com.example.contactapk.DI

import android.app.Application
import androidx.room.Room
import com.example.contactapk.Constant.DATABASE_NAME
import com.example.contactapk.Data.DataBase.ContactApkDataBase
import com.example.contactapk.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    @Provides
    @Singleton
    fun provideContactApkDataBase(application: Application): ContactApkDataBase {
        return Room.databaseBuilder(
            application,
            ContactApkDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepo(database: ContactApkDataBase): Repo {
        return Repo(database)
    }


}


