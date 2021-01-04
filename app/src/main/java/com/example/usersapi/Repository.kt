package com.example.usersapi

import com.example.usersapi.RetrofitInstance
import com.example.usersapi.Users
import javax.inject.Inject

class Repository @Inject constructor(private val usersApi: Api) {

    suspend fun getUsers() : Users {
        return usersApi.getUsers()
    }
}