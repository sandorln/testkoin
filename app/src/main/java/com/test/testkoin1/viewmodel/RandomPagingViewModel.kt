package com.test.testkoin1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.test.testkoin1.api.RandomUserService
import com.test.testkoin1.api.data.randomuser.RandomUser
import com.test.testkoin1.datasource.RandomUserDataSource
import java.util.concurrent.Executors

class RandomPagingViewModel(
    application: Application,
    private val randomUserService: RandomUserService,
    private val pagedConfig: PagedList.Config
) : AndroidViewModel(application) {

    private val randomUserDataSourceFactory: MutableLiveData<RandomUserDataSource.Factory> =
        MutableLiveData<RandomUserDataSource.Factory>().apply { value = RandomUserDataSource.Factory(randomUserService) }

    val randomUserDataList: LiveData<PagedList<RandomUser>> = Transformations.switchMap(randomUserDataSourceFactory) {
        LivePagedListBuilder(it, pagedConfig).setFetchExecutor(Executors.newFixedThreadPool(5)).build()
    }

    val errorMsg: LiveData<String> = Transformations.switchMap(randomUserDataSourceFactory) { it.errorMsg }

    fun refreshRandomUserData() {
        randomUserDataSourceFactory.postValue(RandomUserDataSource.Factory(randomUserService))
    }
}