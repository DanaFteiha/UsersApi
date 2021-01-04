package com.example.usersapi

//import retrofit2.converter.scalars.ScalarsConverterFactory

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


//Base URL
private const val BASE_URL = "https://randomuser.me"

//interface that defines how Retrofit talks to the web server using HTTP requests
//Returns a Coroutine [List] of [Users] which can be fetched with await() if in a Coroutine scope.
interface Api {
    @GET("/api/")
   // @Query("query") Login: String
    suspend fun getUsers() : Users
}

//Retrofit object "Singelton"
object RetrofitInstance {
    //Moshi object
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        Retrofit.Builder()
            .baseUrl(BASE_URL).client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    //A public Api object that exposes the lazy-initialized Retrofit service
    val UsersApi: Api by lazy {
        retrofit.create(Api::class.java)
    }
}



