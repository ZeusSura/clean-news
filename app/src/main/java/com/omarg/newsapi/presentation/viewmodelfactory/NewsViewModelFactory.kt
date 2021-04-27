package com.omarg.newsapi.presentation.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omarg.newsapi.domain.usecase.GetNewsHeadlinesUseCase
import com.omarg.newsapi.presentation.viewmodel.NewsViewModel

class NewsViewModelFactory(
    private val app:Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app,getNewsHeadlinesUseCase) as T
    }
}