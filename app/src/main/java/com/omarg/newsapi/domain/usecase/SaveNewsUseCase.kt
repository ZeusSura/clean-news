package com.omarg.newsapi.domain.usecase

import com.omarg.newsapi.data.models.Article
import com.omarg.newsapi.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {


    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}