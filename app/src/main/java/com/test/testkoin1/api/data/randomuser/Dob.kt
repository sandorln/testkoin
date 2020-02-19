package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("date")
    val dDate: String = "",
    @SerializedName("age")
    val dAge: Int = -1
)