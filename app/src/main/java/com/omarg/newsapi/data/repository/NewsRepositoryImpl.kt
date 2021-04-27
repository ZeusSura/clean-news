package com.omarg.newsapi.data.repository

import com.omarg.newsapi.data.models.Article
import com.omarg.newsapi.data.models.NewsHeadlineResponse
import com.omarg.newsapi.data.repository.datasource.NewsRemoteDataSource
import com.omarg.newsapi.data.util.Resource
import com.omarg.newsapi.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    override suspend fun getNewsHeadLines(
        country: String,
        page: Int,
        lenguaje: String
    ): Resource<NewsHeadlineResponse> {
        return responseToResource(
            newsRemoteDataSource.getTopHeadline(
                country,
                page,
                lenguaje = lenguaje
            )
        )
    }

    fun responseToResource(response: Response<NewsHeadlineResponse>): Resource<NewsHeadlineResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun searchedNews(searchQuery: String): Resource<NewsHeadlineResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

}