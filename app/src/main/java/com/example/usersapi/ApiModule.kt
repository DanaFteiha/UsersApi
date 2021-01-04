package com.example.usersapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

//Base URL
private const val BASE_URL = "https://randomuser.me"

@Module
class ApiModule {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // @Provides tell Dagger how to create instances of the type that this function
    //Retrofit object "Singleton"
    @Singleton
    @Provides
    fun provideRetrofitService() : Api{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        //A public Api object that exposes the lazy-initialized Retrofit service
        return retrofit.create(Api::class.java)
    }
}