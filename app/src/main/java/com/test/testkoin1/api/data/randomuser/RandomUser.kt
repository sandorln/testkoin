package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class RandomUser(
    @SerializedName("gender")
    val uGender: String = "",
    @SerializedName("name")
    val uName: UserName = UserName(),
    @SerializedName("location")
    val uLocation: Location = Location(),
    @SerializedName("email")
    val uEmail: String = "",
    @SerializedName("login")
    val uLogin: Login = Login(),
    @SerializedName("dob")
    val uDob: Dob = Dob(),
    @SerializedName("registered")
    val uRegistered: Registered = Registered(),
    @SerializedName("phone")
    val uPhone: String = "",
    @SerializedName("cell")
    val uCell: String = "",
    @SerializedName("id")
    val uId: UserId = UserId(),
    @SerializedName("picture")
    val uPicture: Picture = Picture(),
    @SerializedName("nat")
    val uNat: String = ""
)
