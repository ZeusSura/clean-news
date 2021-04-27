package com.omarg.newsapi.data.api

import com.omarg.newsapi.BuildConfig
import com.omarg.newsapi.data.models.NewsHeadlineResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apikey")
        apiKye: String = BuildConfig.API_KEY,
        @Query("lenguaje")
        lenguaje: String
    ): Response<NewsHeadlineResponse>

}