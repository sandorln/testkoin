package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("date")
    val rDate: String = "",
    @SerializedName("age")
    val rAge: Int = -1
)