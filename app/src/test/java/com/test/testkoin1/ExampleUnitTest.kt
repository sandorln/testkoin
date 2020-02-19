package com.test.testkoin1

import com.test.testkoin1.api.RandomUserService
import com.test.testkoin1.api.response.RandomResponse
import com.test.testkoin1.di.apiModule
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.CountDownLatch

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : KoinTest {

    val randomUserService: RandomUserService by inject()
    val countDownLatch = CountDownLatch(1)

    @Before
    fun before() {
        startKoin {
            modules(apiModule)
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testRetrofit() {
        randomUserService.getRandomUser(10, 1)
            .enqueue(object : Callback<RandomResponse> {
                override fun onFailure(call: Call<RandomResponse>, t: Throwable) {
                    countDownLatch.countDown()
                }

                override fun onResponse(call: Call<RandomResponse>, response: Response<RandomResponse>) {
                    println("${response.body()!!.rResults[0]}")
                    countDownLatch.countDown()
                }
            })

        countDownLatch.await()
    }
}
