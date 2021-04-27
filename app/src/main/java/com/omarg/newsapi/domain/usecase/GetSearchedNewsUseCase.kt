package com.omarg.newsapi.domain.usecase

import com.omarg.newsapi.data.models.NewsHeadlineResponse
import com.omarg.newsapi.data.util.Resource
import com.omarg.newsapi.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun exceute(searchQuery:String):Resource<NewsHeadlineResponse> = newsRepository.searchedNews(searchQuery)
}