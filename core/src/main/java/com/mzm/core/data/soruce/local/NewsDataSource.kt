package com.mzm.core.data.soruce.local

import androidx.paging.DataSource
import com.mzm.core.data.soruce.local.entity.ArticlesEntity
import com.mzm.core.data.soruce.local.entity.SourcesEntity
import com.mzm.core.data.soruce.local.room.dao.NewsDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class NewsDataSource @Inject constructor(
    private val newsDao: NewsDao,
) {

    fun getCategory(): DataSource.Factory<Int, ArticlesEntity> = newsDao.getCategoryNews()

    suspend fun insertCategoryNews(category: List<ArticlesEntity>) =
        newsDao.insertCategoryNews(category)

    suspend fun deleteAndInsertCatagoryNews(catagory: List<ArticlesEntity>) =
        newsDao.deleteAndInsertCategoryNews(catagory)

    suspend fun deleteCategoryNews() = newsDao.deleteCategoryNews()

    fun getSources(): DataSource.Factory<Int, SourcesEntity> = newsDao.getSources()

    suspend fun insertSources(sources: List<SourcesEntity>) = newsDao.insertSources(sources)

    suspend fun deleteAndInsertSources(sources: List<SourcesEntity>) =
        newsDao.deleteAndInsertSources(sources)

    suspend fun deleteSources() = newsDao.deleteSources()

}