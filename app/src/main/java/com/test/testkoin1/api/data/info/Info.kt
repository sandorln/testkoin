package com.test.testkoin1.api.data.info

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("seed")
    val iSeed: String = "",
    @SerializedName("results")
    val iResults: Int = -1,
    @SerializedName("page")
    val iPage: Int = 1,
    @SerializedName("version")
    val iVersion: String = ""
)