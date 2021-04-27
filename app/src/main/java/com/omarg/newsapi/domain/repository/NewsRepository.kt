package com.omarg.newsapi.domain.repository

import com.omarg.newsapi.data.models.Article
import com.omarg.newsapi.data.models.NewsHeadlineResponse
import com.omarg.newsapi.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadLines(country:String,page:Int,lenguaje:String):Resource<NewsHeadlineResponse>
    suspend fun searchedNews(searchQuery:String):Resource<NewsHeadlineResponse>
    suspend fun saveNews(article:Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews():Flow<List<Article>>
}