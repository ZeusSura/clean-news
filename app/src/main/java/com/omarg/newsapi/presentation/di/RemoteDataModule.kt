package com.omarg.newsapi.presentation.di

import com.omarg.newsapi.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataModule {

    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService) {

    }
}