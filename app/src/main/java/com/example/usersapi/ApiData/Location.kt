package com.example.usersapi.ApiData

data class Location(
    val city: String,
    val coordinates: Coordinates,
    val postcode: String,
    val state: String,
    val street: Any,
    val timezone: Timezone
)