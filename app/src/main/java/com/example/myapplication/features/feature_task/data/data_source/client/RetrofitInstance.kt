package com.example.myapplication.features.feature_task.data.data_source.client

import com.example.myapplication.common.helper.date.DateHelper
import com.example.myapplication.features.feature_task.data.repository.TaskClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:5022/api/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    val api: TaskClient by lazy {
        val moshi = Moshi.Builder()
            .add(DateHelper())
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(TaskClient::class.java)
    }
}