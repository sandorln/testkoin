package com.test.testkoin1.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.testkoin1.api.RandomUserService
import com.test.testkoin1.api.data.randomuser.RandomUser
import com.test.testkoin1.api.response.RandomResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomRepository(private val randomService: RandomUserService) {

    val errorMsg: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    var pageCount = 1

    fun getRandomUserList(pageCount: Int): LiveData<List<RandomUser>> {
        val responseLiveData = MutableLiveData<List<RandomUser>>().apply { value = mutableListOf() }

        randomService.getRandomUser(10, pageCount)
            .enqueue(object : Callback<RandomResponse> {
                override fun onFailure(call: Call<RandomResponse>, t: Throwable) = errorMsg.postValue("Error !! [${t.message}]")
                override fun onResponse(call: Call<RandomResponse>, response: Response<RandomResponse>) {
                    responseLiveData.postValue(response.body()!!.rResults)
                }
            })

        return responseLiveData
    }
}