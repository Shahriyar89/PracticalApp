package com.matrix87

import com.matrix87.activities.Comment
import com.matrix87.activities.UserInfo
import retrofit2.Call
import retrofit2.http.*

interface MyServices {
    @GET("/comments")
    fun getAllComments(): Call<List<Comment>>

    @POST ("insert")
    fun setComment(
        @Header("header") header:String
    )

    @PUT("update")
    fun updateComment()

    @DELETE("")
    fun deleteComment()

    @GET("Users")
   fun  getUsers():Call<List<UserInfo>>

    @POST("Users")
    fun insertUser(
        @Body user :UserInfo
    )
}