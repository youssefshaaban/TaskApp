package com.example.taskapp.data.remote


import com.example.taskapp.data.model.ResponseMedicines
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v3/25dc6df1-965a-4a07-baed-69492b76bb31")
    suspend fun getMedicines(): Response<ResponseMedicines>

}