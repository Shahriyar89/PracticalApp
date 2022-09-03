package com.matrix87.activities

import retrofit2.Call
import retrofit2.http.GET

interface Services {
    @GET("comments")
    suspend fun getComments(): Call<List<Comment>>
}