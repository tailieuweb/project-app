package com.example.projecttask.apis

import com.example.projecttask.BuildConfig
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import javax.inject.Inject


class WebServiceApi @Inject constructor (private val okHttpClient: OkHttpClient,
                                         private val retrofit: Retrofit) {
    private val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .create()

    // {"token":"123456798","user":{"id":1,"name":1,"email":"1@gmail.com"}}
    data class UserData(val id: String, val name: String, val email: String)
    data class LoginData(val token: String, val user: UserData)


    fun login(userName: String, password: String): Single<LoginData> {
        return Single.create<LoginData> { emitter ->
            try {
                val url =
                    "${BuildConfig.BASE_SERVICE_URL}/login"

                val request = Request.Builder()
                    .url(url)
                    .get() // TODO: replace get = post with body
                    .build()

                val response = okHttpClient.newCall(request).execute()
                if (response.isSuccessful) {
                    val loginData = gson.fromJson(response.body?.string(), LoginData::class.java)

                    emitter.onSuccess(loginData)
                } else {
                    emitter.onError(Exception("Error"))
                }

            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

}