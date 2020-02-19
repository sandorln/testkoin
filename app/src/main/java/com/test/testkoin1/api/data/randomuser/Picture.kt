package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("large")
    val pLarge: String = "",
    @SerializedName("medium")
    val pMedium: String = "",
    @SerializedName("thumbnail")
    val pThumbnail: String = ""
)