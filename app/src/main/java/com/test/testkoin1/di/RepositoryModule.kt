package com.test.testkoin1.di

import com.test.testkoin1.repository.RandomRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { RandomRepository(get()) }
}