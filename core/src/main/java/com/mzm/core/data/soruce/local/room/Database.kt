package com.mzm.core.data.soruce.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mzm.core.data.soruce.local.entity.ArticlesEntity
import com.mzm.core.data.soruce.local.entity.CategoryNewsRemoteKeys
import com.mzm.core.data.soruce.local.entity.SourcesEntity
import com.mzm.core.data.soruce.local.room.dao.NewsDao
import com.mzm.core.util.Constants.DATABASE_VERSION

/**
 * Created by Muhammad Zaim Milzam on 10/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Database(
    entities = [
        ArticlesEntity::class,
        CategoryNewsRemoteKeys::class,
        SourcesEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun newsDao(): NewsDao
//    abstract fun categoryRemoteKeysDao(): CategoryRemoteKeysDao

}