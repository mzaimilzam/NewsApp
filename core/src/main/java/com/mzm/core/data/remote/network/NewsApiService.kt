package com.mzm.core.data.remote.network

import com.mzm.core.data.remote.response.CatetegoryResponse
import com.mzm.core.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Muhammad Zaim Milzam on 07/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
interface NewsApiService {

    @GET("top-headlines?apiKey=${Constants.API_KEY}")
    suspend fun getCategoryNews(
        @Query("page") page: Int,
        @Query("category") category: String = "business"
    ): Response<CatetegoryResponse>
}