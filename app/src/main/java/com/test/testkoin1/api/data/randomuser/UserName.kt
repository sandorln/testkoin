package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class UserName(
    @SerializedName("title")
    val nTitle: String = "",
    @SerializedName("first")
    val nFirst: String = "",
    @SerializedName("last")
    val nLast: String = ""
)