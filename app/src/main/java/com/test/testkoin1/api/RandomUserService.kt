package com.test.testkoin1.api

import com.test.testkoin1.api.response.RandomResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {
    @GET("/")
    fun getRandomUser(@Query("results") resultLimit: Int, @Query("page") page: Int): Call<RandomResponse>
}