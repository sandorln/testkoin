package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class UserId(
    @SerializedName("name")
    val uName: String = "",
    @SerializedName("value")
    val uValue: String = ""
)