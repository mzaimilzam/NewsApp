package com.mzm.core.di

import android.content.Context
import androidx.room.Room
import com.mzm.core.data.soruce.local.room.Database
import com.mzm.core.data.soruce.local.room.dao.NewsDao
import com.mzm.core.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, Constants.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideNewsDao(database: Database): NewsDao = database.newsDao()
}