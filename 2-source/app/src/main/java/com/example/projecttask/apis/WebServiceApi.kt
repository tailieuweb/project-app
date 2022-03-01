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
    data class UserData(
        val id: String,
        val email: String,
        val user_name: String
        )
    data class LoginData(
        val token: String,
        val user: UserData
    )

    //Task info
    @Deprecated("No longer needed. Use `Task` instead.")
    data class TaskInfo (
        val task_id: String,
        val task_name: String,
        val task_overview: String,
        val task_description: String
    )

    //[{"id":1,"name":1,"description":""},{"id":2,"name":2,"description":""},{"id":3,"name":3,"description":""}]
    @Deprecated("No longer needed. Use `TaskDetail` instead!")
    data class ListData(
        val id: String,
        val notes: String,
        val task: TaskInfo

    )

    //{"id":1,"name":1,"description":1}
    data class DetailData(
        val id: String,
        val notes: String,
        val taskInfo: TaskInfo
    )


    /**
     * Login
     * url: http://api.tdc.edu.vn/api/login
     * method: post
     * body: email, password
     */
    fun login(email: String, password: String): Single<LoginData> {
        return Single.create<LoginData> { emitter ->
            try {
                val url = "${BuildConfig.BASE_SERVICE_URL}/login"

                val jsonObject = JsonObject()
                jsonObject.addProperty("email", email)
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


    /**
     * Get list of assigned tasks
     * url: http://api.tdc.edu.vn/api/tasks
     * method: GET
     * body: user_id
     * header: token
     */
    fun getList(userId: String, token: String): Single<List<TaskDetail>> {
        return Single.create { emitter ->
            try {
                val url = "${BuildConfig.BASE_SERVICE_URL}/tasks?user_id=${userId}"

                val request = Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer ${token}")
                    .get()
                    .build()

                print("UserID = ${userId}")
                print("Token = ${token}")

                val response = okHttpClient.newCall(request).execute()

                if (response.isSuccessful) {
                    val myList: Array<TaskDetail> = gson.fromJson(response.body?.string(), Array<TaskDetail>::class.java)

                    emitter.onSuccess(myList.toList())
                } else {
                    emitter.onError(Exception("Error"))
                }

            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

    /**
     * Display task info
     */
    fun getDetail(user_id: String, task_id: String): Single<DetailData> {
        return Single.create { emitter ->
            try {
                val url = "${BuildConfig.BASE_SERVICE_URL}/task?user_id=${user_id}&user_id=${task_id}"

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