package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("uuid")
    val lUuid: String = "",
    @SerializedName("username")
    val lUserName: String = "",
    @SerializedName("password")
    val lPassword: String = "",
    @SerializedName("salt")
    val lSalt: String = "",
    @SerializedName("md5")
    val lMd5: String = "",
    @SerializedName("sha1")
    val lSha1: String = "",
    @SerializedName("sha256")
    val lSha256: String = ""
)