package com.omarg.newsapi.data.repository.datasource

import com.omarg.newsapi.data.models.NewsHeadlineResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadline(country:String,page:Int,lenguaje:String): Response<NewsHeadlineResponse>
}