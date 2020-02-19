package com.test.testkoin1.di

import com.test.testkoin1.api.RandomUserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    single {
        Retrofit.Builder().apply {
            baseUrl("http://api.randomuser.me")
            addConverterFactory(GsonConverterFactory.create())
            client(get())
        }.build()
    }

    single {
        OkHttpClient().newBuilder().apply {
            readTimeout(20000L, TimeUnit.MILLISECONDS)
            connectTimeout(10000L, TimeUnit.MILLISECONDS)
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
        }.build()
    }

    single {
        get<Retrofit>().create(RandomUserService::class.java)
    }
}
