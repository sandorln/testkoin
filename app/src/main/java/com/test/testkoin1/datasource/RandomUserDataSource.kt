package com.test.testkoin1.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.test.testkoin1.api.RandomUserService
import com.test.testkoin1.api.data.randomuser.RandomUser
import com.test.testkoin1.api.response.RandomResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomUserDataSource(private val randomUserService: RandomUserService, val errorMsg: MutableLiveData<String>) :
    PageKeyedDataSource<Int, RandomUser>() {

    class Factory(private val randomUserService: RandomUserService) : DataSource.Factory<Int, RandomUser>() {
        val errorMsg: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
        override fun create(): DataSource<Int, RandomUser> = RandomUserDataSource(randomUserService, errorMsg)
    }


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, RandomUser>) {
        randomUserService.getRandomUser(params.requestedLoadSize, 1)
            .enqueue(object : Callback<RandomResponse> {
                override fun onFailure(call: Call<RandomResponse>, t: Throwable) = errorMsg.postValue(t.message)

                override fun onResponse(call: Call<RandomResponse>, response: Response<RandomResponse>) {
                    if (response.body() != null)
                        callback.onResult(response.body()!!.rResults, null, response.body()!!.rInfo.iPage + 1)
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, RandomUser>) {
        randomUserService.getRandomUser(params.requestedLoadSize, params.key)
            .enqueue(object : Callback<RandomResponse> {
                override fun onFailure(call: Call<RandomResponse>, t: Throwable) = errorMsg.postValue(t.message)

                override fun onResponse(call: Call<RandomResponse>, response: Response<RandomResponse>) {
                    if (response.body() != null)
                        callback.onResult(response.body()!!.rResults, response.body()!!.rInfo.iPage + 1)
                }
            })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, RandomUser>) {}
}