package com.test.testkoin1.application

import android.app.Application
import com.test.testkoin1.di.apiModule
import com.test.testkoin1.di.pagingModule
import com.test.testkoin1.di.repositoryModule
import com.test.testkoin1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(mutableListOf(apiModule, pagingModule, viewModelModule, repositoryModule))
        }
    }
}