package com.mzm.core.domain.repository

import androidx.paging.PagedList
import com.mzm.core.data.Resource
import com.mzm.core.domain.model.Articles
import com.mzm.core.domain.model.Sources
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
interface INewsRepository {

    fun getCategoryNews(page: Int, category: String): Flow<Resource<PagedList<Articles>>>

    fun getSource(page: Int): Flow<Resource<PagedList<Sources>>>
}