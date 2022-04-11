package com.mzm.newsapp

import com.mzm.core.domain.usecase.CategoryNewsInteractor
import com.mzm.core.domain.usecase.IUsecaseCategoryNews
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideCategoryNewsUsecase(categoryNewsInteractor: CategoryNewsInteractor): IUsecaseCategoryNews

}