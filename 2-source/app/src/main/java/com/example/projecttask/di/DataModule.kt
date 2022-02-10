package com.example.projecttask.di

import android.content.Context
import com.example.projecttask.BuildConfig
import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.data.MyDatabase
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideDao(context: Context) = MyDatabase()

    @Singleton
    @Provides
    fun provideWebServiceApi(okHttpClient: OkHttpClient, retrofit: Retrofit): WebServiceApi = WebServiceApi(okHttpClient, retrofit)

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://google.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        return retrofit
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return createClient()
    }

    private fun createClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        else
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.readTimeout(180, TimeUnit.SECONDS)
        clientBuilder.connectTimeout(180, TimeUnit.SECONDS)
        clientBuilder.addInterceptor(httpLoggingInterceptor)

        return clientBuilder.build()
    }
}
