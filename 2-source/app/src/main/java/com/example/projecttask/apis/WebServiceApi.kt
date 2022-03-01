package com.example.projecttask.apis

import com.example.projecttask.BuildConfig
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import javax.inject.Inject


class WebServiceApi @Inject constructor (private val okHttpClient: OkHttpClient,
                                         private val retrofit: Retrofit) {
    private val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .create()

    val JSON = "application/json; charset=utf-8".toMediaType()

    // {"token":"123456798","user":{"id":1,"name":1,"email":"1@gmail.com"}}
    data class UserData(val id: String, val name: String, val email: String)
    data class LoginData(val token: String, val user: UserData)

    //[{"id":1,"name":1,"description":""},{"id":2,"name":2,"description":""},{"id":3,"name":3,"description":""}]
    data class ListData(val id: String, val name: String, val description: String)

    //{"id":1,"name":1,"description":1}
    data class DetailData(val id: String, val name: String, val description: String)

    fun login(userName: String, password: String): Single<LoginData> {
        return Single.create<LoginData> { emitter ->
            try {
                val url =
                    "${BuildConfig.BASE_SERVICE_URL}/login"

                val jsonObject = JsonObject()
                jsonObject.addProperty("email", userName)
                jsonObject.addProperty("password", password)
                val body = gson.toJson(jsonObject).toRequestBody(JSON)
                val request = Request.Builder()
                    .url(url)
                    .post(body)
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


    fun getList(userId: String, token: String): Single<List<ListData>> {
        return Single.create<List<ListData>> { emitter ->
            try {
                val url =
                    "${BuildConfig.BASE_SERVICE_URL}/list/${userId}"

                val request = Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer ${token}")
                    .get()
                    .build()

                val response = okHttpClient.newCall(request).execute()
                if (response.isSuccessful) {
                    val myList: Array<ListData> = gson.fromJson(response.body?.string(), Array<ListData>::class.java)

                    emitter.onSuccess(myList.toList())
                } else {
                    emitter.onError(Exception("Error"))
                }

            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

    fun getDetail(id: String): Single<DetailData> {
        return Single.create { emitter ->
            try {
                val url =
                    "${BuildConfig.BASE_SERVICE_URL}/detail"

                val request = Request.Builder()
                    .url(url)
                    .get() // TODO: replace get = post with body
                    .build()

                val response = okHttpClient.newCall(request).execute()
                if (response.isSuccessful) {
                    val detail = gson.fromJson(response.body?.string(), DetailData::class.java)

                    emitter.onSuccess(detail)
                } else {
                    emitter.onError(Exception("Error"))
                }

            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

}