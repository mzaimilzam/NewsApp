package com.mzm.core.domain.usecase

import androidx.paging.PagedList
import com.mzm.core.data.Resource
import com.mzm.core.data.soruce.repository.NewsRepository
import com.mzm.core.domain.model.Articles
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
class CategoryNewsInteractor @Inject constructor(private val newsRepository: NewsRepository) :
    IUsecaseCategoryNews {
    override fun getCategoryNews(
        page: Int,
        category: String
    ): Flow<Resource<PagedList<Articles>>> =
        newsRepository.getCategoryNews(page = page, category = category)
}