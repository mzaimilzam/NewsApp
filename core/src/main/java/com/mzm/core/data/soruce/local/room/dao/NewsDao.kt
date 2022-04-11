package com.mzm.core.data.soruce.local.room.dao

import androidx.paging.DataSource
import androidx.room.*
import com.mzm.core.data.soruce.local.entity.ArticlesEntity
import com.mzm.core.data.soruce.local.entity.SourcesEntity

/**
 * Created by Muhammad Zaim Milzam on 10/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Dao
interface NewsDao {
    /**
     * get category news
     */

    @Query("SELECT * FROM article_entity")
    fun getCategoryNews(): DataSource.Factory<Int, ArticlesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoryNews(category: List<ArticlesEntity>)

    @Query("DELETE FROM article_entity")
    suspend fun deleteCategoryNews()

    @Transaction
    suspend fun deleteAndInsertCategoryNews(category: List<ArticlesEntity>) {
        deleteCategoryNews()
        insertCategoryNews(category)
    }

    /**
     * get Source news
     */

    @Query("SELECT * FROM sources_entity")
    fun getSources(): DataSource.Factory<Int, SourcesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSources(sources: List<SourcesEntity>)

    @Query("DELETE FROM sources_entity")
    suspend fun deleteSources()

    @Transaction
    suspend fun deleteAndInsertSources(sources: List<SourcesEntity>) {
        deleteSources()
        insertSources(sources)
    }

}