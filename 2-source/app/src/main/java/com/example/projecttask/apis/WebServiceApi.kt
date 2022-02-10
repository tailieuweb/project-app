package com.example.projecttask.apis

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject


class WebServiceApi @Inject constructor (private val okHttpClient: OkHttpClient,
                                         private val retrofit: Retrofit) {

}