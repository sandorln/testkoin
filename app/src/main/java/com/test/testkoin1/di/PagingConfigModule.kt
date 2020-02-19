package com.test.testkoin1.di

import androidx.paging.PagedList
import org.koin.dsl.module

val pagingModule = module {
    single {
        PagedList.Config.Builder().apply {
            setPageSize(10)
            setInitialLoadSizeHint(50)
            setEnablePlaceholders(true)
        }.build()
    }
}