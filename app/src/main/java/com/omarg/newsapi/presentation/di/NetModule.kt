package com.omarg.newsapi.presentation.di

import com.omarg.newsapi.BuildConfig
import com.omarg.newsapi.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(BuildConfig.BASE_URL_NEWS)
            client(OkHttpClient.Builder().apply {
                callTimeout(120, TimeUnit.SECONDS)
                readTimeout(120, TimeUnit.SECONDS)
                writeTimeout(120, TimeUnit.SECONDS)
            }.build())
        }.build()
    }

    @Singleton
    fun providesNeswsAPIService(retrofit: Retrofit):NewsAPIService {

       return  retrofit.create(NewsAPIService::class.java)
    }
}