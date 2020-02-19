package com.test.testkoin1.di

import com.test.testkoin1.viewmodel.RandomPagingViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RandomPagingViewModel(androidApplication(), get(), get()) }
}