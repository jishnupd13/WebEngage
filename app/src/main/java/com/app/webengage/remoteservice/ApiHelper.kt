package com.app.webengage.remoteservice

import com.app.webengage.models.TestApiResponseModel
import retrofit2.Response

interface ApiHelper {
    suspend fun getPosts(): Response<List<TestApiResponseModel>>


}