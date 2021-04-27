package com.omarg.newsapi.domain.usecase

import com.omarg.newsapi.data.models.NewsHeadlineResponse
import com.omarg.newsapi.data.util.Resource
import com.omarg.newsapi.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(
        country: String,
        page: Int,
        lenguaje: String
    ): Resource<NewsHeadlineResponse> =
        newsRepository.getNewsHeadLines(country, page, lenguaje = lenguaje)
}