package com.omarg.newsapi.domain.usecase

import com.omarg.newsapi.data.models.Article
import com.omarg.newsapi.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository){


     fun execute():Flow<List<Article>> = newsRepository.getSavedNews()
}