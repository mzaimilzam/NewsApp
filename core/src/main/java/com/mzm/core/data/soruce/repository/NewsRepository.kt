package com.mzm.core.data.soruce.repository

import androidx.lifecycle.asFlow
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mzm.core.data.NetworkBoundResource
import com.mzm.core.data.Resource
import com.mzm.core.data.soruce.local.NewsDataSource
import com.mzm.core.data.soruce.remote.ApiResponse
import com.mzm.core.data.soruce.remote.RemoteDataSource
import com.mzm.core.data.soruce.remote.response.ArticlesItem
import com.mzm.core.domain.model.Articles
import com.mzm.core.domain.model.Sources
import com.mzm.core.domain.repository.INewsRepository
import com.mzm.core.util.data_mapper.DataMapperCattegory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class NewsRepository @Inject constructor(
    private val local: NewsDataSource,
    private val remote: RemoteDataSource,
) : INewsRepository {
    override fun getCategoryNews(
        page: Int,
        category: String
    ): Flow<Resource<PagedList<Articles>>> =
        object : NetworkBoundResource<PagedList<Articles>, List<ArticlesItem>>() {
            override fun loadFromDB(): Flow<PagedList<Articles>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(
                    local.getCategory().map { DataMapperCattegory.mapEntitiestoDomain(it) }, config
                ).build().asFlow()
            }

            override fun shouldFetch(data: PagedList<Articles>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<ArticlesItem>>> =
                remote.getCategoryNews(
                    page,
                    category = category
                ) as Flow<ApiResponse<List<ArticlesItem>>>

            override suspend fun saveCallResult(data: List<ArticlesItem>) {
                val list = DataMapperCattegory.mapResponsetoEntities(data)
                if (page == 1) {
                    local.deleteAndInsertCatagoryNews(list)
                } else {
                    local.insertCategoryNews(list)
                }
            }

            override suspend fun emptyDataBase() {
                local.deleteCategoryNews()
            }

        }.asFlow()

    override fun getSource(page: Int): Flow<Resource<PagedList<Sources>>> {
        TODO("Not yet implemented")
    }


}