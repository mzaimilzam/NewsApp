package com.mzm.core.data.soruce.remote

import com.mzm.core.data.soruce.remote.network.NewsApiService
import com.mzm.core.data.soruce.remote.response.ArticlesItem
import com.mzm.core.data.soruce.remote.response.SourcesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class RemoteDataSource @Inject constructor(
    private val newsApiService: NewsApiService
) {

    suspend fun getCategoryNews(
        page: Int,
        category: String
    ): Flow<ApiResponse<List<ArticlesItem?>>> {
        return flow {
            try {
                val response =
                    newsApiService.getCategoryNews(category = category, page = page).body()?.articles
                val data = newsApiService.getCategoryNews(category = category, page = page)
                if (data.code() == 200) {
                    if (response != null) {
                        if (response.isNullOrEmpty()) {
                            emit(ApiResponse.Empty)
                        } else {
                            emit(ApiResponse.Success(response))
                        }
                    } else {
                        emit(ApiResponse.Empty)
                    }
                } else {
                    emit(ApiResponse.Error(data.message()))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }catch (e : HttpException) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getSources(): Flow<ApiResponse<SourcesResponse>> {
        return flow {
            try {
                val response =
                    newsApiService.getSoruces().body()
                val data = newsApiService.getSoruces()
                if (data.code() == 200) {
                    if (response != null) {
                        if (response.sources.isNullOrEmpty()) {
                            emit(ApiResponse.Empty)
                        } else {
                            emit(ApiResponse.Success(response))
                        }
                    } else {
                        emit(ApiResponse.Empty)
                    }
                } else {
                    emit(ApiResponse.Error(data.message()))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }catch (e : HttpException) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}