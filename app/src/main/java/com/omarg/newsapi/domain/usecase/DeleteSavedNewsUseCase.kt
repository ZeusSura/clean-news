package com.omarg.newsapi.domain.usecase

import com.omarg.newsapi.data.models.Article
import com.omarg.newsapi.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

   suspend fun exceute( article: Article) = newsRepository.deleteNews(article)
}
