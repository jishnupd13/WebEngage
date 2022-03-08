package com.app.webengage.remoteservice

import com.app.webengage.models.TestApiResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<List<TestApiResponseModel>>
}