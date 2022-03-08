package com.app.webengage.remoteservice

import com.app.webengage.models.TestApiResponseModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImplementation @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getPosts(): Response<List<TestApiResponseModel>> = apiService.getPosts()
}