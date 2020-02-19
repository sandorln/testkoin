package com.test.testkoin1.api.data.randomuser

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("street")
    val lStreet: Street = Street(),
    @SerializedName("city")
    val lCity: String = "",
    @SerializedName("state")
    val lState: String = "",
    @SerializedName("country")
    val lCountry: String = "",
    @SerializedName("postcode")
    val lPostCode: String = "",
    @SerializedName("coordinates")
    val lCoordinates: Coordinates = Coordinates(),
    @SerializedName("timezone")
    val lTimezone: Timezone = Timezone()
)

data class Street(
    @SerializedName("number")
    val sNumber: String = "",
    @SerializedName("name")
    val sName: String = ""
)

data class Coordinates(
    @SerializedName("latitude")
    val cLat: String = "",
    @SerializedName("longitude")
    val cLong: String = ""
)

data class Timezone(
    @SerializedName("offset")
    val tOffset: String = "",
    @SerializedName("description")
    val tDescription: String = ""
)
