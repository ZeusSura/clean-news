package com.omarg.newsapi.data.repository.datasourceimpl

import com.omarg.newsapi.data.api.NewsAPIService
import com.omarg.newsapi.data.models.NewsHeadlineResponse
import com.omarg.newsapi.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
) : NewsRemoteDataSource {


    override suspend fun getTopHeadline(
        country: String,
        page: Int,
        lenguaje: String
    ): Response<NewsHeadlineResponse> {
        return newsAPIService.getTopHeadlines(country, page, lenguaje = lenguaje)
    }

}