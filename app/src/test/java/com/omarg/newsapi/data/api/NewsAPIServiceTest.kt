package com.omarg.newsapi.data.api


import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets.UTF_8
import com.google.common.truth.Truth.assertThat


class NewsAPIServiceTest {

    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }


    private fun enqueueMockResponse(
        fileName: String
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(UTF_8))
        server.enqueue(mockResponse)
    }


    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val body = service.getTopHeadlines("mx", 1, lenguaje = "es").body()
            val reques = server.takeRequest()
            assertThat(body).isNotNull()
            assertThat(reques.path).isEqualTo("/top-headlines?country=mx&page=1&apikey=4396d990f40e4f7e86091f57a7a886a9&lenguaje=es")
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize() {

        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val body = service.getTopHeadlines("mx", 1, lenguaje = "es").body()
            assertThat(body!!.articles.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent() {

        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val body = service.getTopHeadlines("mx", 1, lenguaje = "es").body()
            val articlest = body!!.articles
            val article = articlest[0]
            assertThat(article.author).isEqualTo(null)
        }

    }
}