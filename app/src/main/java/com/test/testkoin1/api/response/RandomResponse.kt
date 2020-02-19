package com.test.testkoin1.api.response

import com.google.gson.annotations.SerializedName
import com.test.testkoin1.api.data.info.Info
import com.test.testkoin1.api.data.randomuser.RandomUser

data class RandomResponse(
    @SerializedName("results")
    val rResults: List<RandomUser> = mutableListOf(),
    @SerializedName("info")
    val rInfo: Info = Info()
)