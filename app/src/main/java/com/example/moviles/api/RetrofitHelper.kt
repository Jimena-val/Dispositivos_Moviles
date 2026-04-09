package com.example.moviles.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val URL_BASE = "https://dog.ceo/api/"

    fun getRetrofitService(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL_BASE)
            .build()
        val services: ApiInterface = retrofit.create(ApiInterface::class.java)
        return services
    }
}