package com.example.usersapi

import com.example.usersapi.ApiData.Info
import com.example.usersapi.ApiData.Result

data class Users(
    val info: Info,
    val results: List<Result>
)