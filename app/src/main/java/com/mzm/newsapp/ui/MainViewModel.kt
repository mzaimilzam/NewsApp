package com.mzm.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mzm.core.domain.usecase.IUsecaseCategoryNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsusecase: IUsecaseCategoryNews
) : ViewModel() {


    fun getCategory() = newsusecase.getCategoryNews(1, "business").asLiveData()
}