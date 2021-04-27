package com.omarg.newsapi.data.models


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String
)