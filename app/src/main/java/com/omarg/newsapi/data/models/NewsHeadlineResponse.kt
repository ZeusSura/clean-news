package com.omarg.newsapi.data.models


import com.google.gson.annotations.SerializedName

data class NewsHeadlineResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)