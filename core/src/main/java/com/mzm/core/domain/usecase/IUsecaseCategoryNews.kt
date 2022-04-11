package com.mzm.core.domain.usecase

import androidx.paging.PagedList
import com.mzm.core.data.Resource
import com.mzm.core.domain.model.Articles
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
interface IUsecaseCategoryNews {

    fun getCategoryNews(page: Int, category: String): Flow<Resource<PagedList<Articles>>>
}